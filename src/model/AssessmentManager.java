package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.*;

public class AssessmentManager {
	public static ArrayList<AssessmentDetails> retrieveAssessment(String examCode) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "SELECT * FROM T_ASSESSMENT WHERE C_EXAM_CODE=?";
			
			ArrayList<AssessmentDetails> Assessment = new ArrayList<AssessmentDetails>();

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, examCode);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String moduleCode = rs.getString("C_MODULE_CODE");
				String moduleName = rs.getString("C_MODULE_NAME");
				int period = rs.getInt("C_PERIOD");
				String datetime = rs.getString("C_DATETIME");
				examCode = rs.getString("C_EXAM_CODE");

				AssessmentDetails ad = new AssessmentDetails(moduleCode, moduleName, period, datetime, examCode);
				Assessment.add(ad);
			}
			conn.close();
			return Assessment; 
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
