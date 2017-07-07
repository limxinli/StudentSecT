package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db.DBConnection;

public class StudentInfoManager {
	
	public static void updateAssessment(String examCode, String adminNo) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "UPDATE T_STUDENT_INFO SET C_EXAM_CODE=? WHERE C_ADMISSION_NO=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, examCode);
			pstmt.setString(2, adminNo);
			
			pstmt.executeUpdate();
			
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
