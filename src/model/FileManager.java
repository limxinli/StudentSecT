package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.*;

public class FileManager {
	public static ArrayList<FileDetails> retrieveFile(String examCode) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "SELECT C_FILE_NAME, C_FILE_LINK FROM T_FILE_INFO WHERE C_EXAM_CODE=?";
			
			ArrayList<FileDetails> File = new ArrayList<FileDetails>();

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, examCode);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String fileName = rs.getString("C_FILE_NAME");
				String fileLink = rs.getString("C_FILE_LINK");

				FileDetails fd = new FileDetails(fileName, fileLink);
				File.add(fd);
			}
			conn.close();
			return File; 
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
