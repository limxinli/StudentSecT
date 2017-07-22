package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.DBConnection;

public class StudentManager {
	
	public static void updateStudentInfo(int tableNo, String examCode, String adminNo) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "UPDATE T_STUDENT_INFO SET C_TABLE_NO=?, C_ASSESSMENT_ID=(SELECT C_ID FROM T_ASSESSMENT WHERE C_EXAM_CODE=?), C_LOGIN=1 WHERE C_ADMISSION_NO=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tableNo);
			pstmt.setString(2, examCode);
			pstmt.setString(3, adminNo);
			
			pstmt.executeUpdate();
			
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static ArrayList<StudentDetails> retrieveStudent(String adminNo) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "SELECT * FROM T_STUDENT_INFO WHERE C_ADMISSION_NO=?";
			
			ArrayList<StudentDetails> Student = new ArrayList<StudentDetails>();

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adminNo);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("C_ID");
				adminNo = rs.getString("C_ADMISSION_NO");
				int tableNo = rs.getInt("C_TABLE_NO");
				String ip = rs.getString("C_IP");
				String port = rs.getString("C_PORT");
				String timestamp = rs.getString("C_TIMESTAMP");
				String uniqueCode = rs.getString("C_UNIQUE_CODE");
				int cheating = rs.getInt("C_CHEATING");
				int disconnected = rs.getInt("C_DISCONNECTED");
				int assessmentId = rs.getInt("C_ASSESSMENT_ID");
				int sskl = rs.getInt("C_SS_KL");
				int login = rs.getInt("C_LOGIN");
				

				StudentDetails sid = new StudentDetails(id, adminNo, tableNo, ip, port, timestamp, uniqueCode, cheating, disconnected, assessmentId, sskl, login);
				Student.add(sid);
			}
			conn.close();
			return Student; 
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public static void updateStudentInfo(String adminNo) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "UPDATE T_STUDENT_INFO SET C_DISCONNECTED=1, C_LOGIN=0 WHERE C_ADMISSION_NO=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adminNo);
			
			pstmt.executeUpdate();
			
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
