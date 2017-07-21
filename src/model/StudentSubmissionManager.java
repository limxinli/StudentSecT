package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.DBConnection;

public class StudentSubmissionManager {
	public static void insertStudentSubmission(String adminNo, String uCode) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "INSERT INTO T_STUDENT_SUBMISSION(C_ADMISSION_NO, C_UNIQUE_CODE) VALUES (?, ?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adminNo);
			pstmt.setString(2, uCode);
			
			pstmt.executeUpdate();
			
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static ArrayList<StudentSubmissionDetails> retrieveStudentSubmission(String adminNo) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "SELECT * FROM T_STUDENT_SUBMISSION WHERE C_ADMISSION_NO=?";
			
			ArrayList<StudentSubmissionDetails> StudentSub = new ArrayList<StudentSubmissionDetails>();

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adminNo);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("C_ID");
				String uCode = rs.getString("C_UNIQUE_CODE");
				
				StudentSubmissionDetails ssd = new StudentSubmissionDetails(id, adminNo, uCode);
				StudentSub.add(ssd);
			}
			conn.close();
			return StudentSub; 
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public static void updateStudentSubmission(String adminNo, String uCode) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "UPDATE T_STUDENT_SUBMISSION SET C_UNIQUE_CODE=? WHERE C_ADMISSION_NO=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uCode);
			pstmt.setString(2, adminNo);
			
			pstmt.executeUpdate();
			
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
