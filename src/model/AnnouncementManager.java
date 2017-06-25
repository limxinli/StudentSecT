package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import db.*;

public class AnnouncementManager{
	public static ArrayList<AnnouncementDetails> retrieveAnnouncement(String examCode) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "SELECT * FROM T_ANNOUNCEMENT WHERE C_EXAM_CODE=? ORDER BY TIME(C_TIMESTAMP) DESC";
			
			ArrayList<AnnouncementDetails> Announcement = new ArrayList<AnnouncementDetails>();

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, examCode);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String moduleCode = rs.getString("C_MODULE_CODE");
				String moduleName = rs.getString("C_MODULE_NAME");
				String lecturerName = rs.getString("C_LECTURER_NAME");
				String announcement = rs.getString("C_ANNOUNCEMENT");
				Timestamp timestamp = rs.getTimestamp("C_TIMESTAMP");
				examCode = rs.getString("C_EXAM_CODE");

				AnnouncementDetails ad = new AnnouncementDetails(moduleCode, moduleName, lecturerName, announcement, timestamp, examCode);
				Announcement.add(ad);
			}
			conn.close();
			return Announcement; 
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
