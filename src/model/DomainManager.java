package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import db.DBConnection;

public class DomainManager {
	public static ArrayList<DomainDetails> retrieveDomain(String assessmentID) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "SELECT * FROM T_WHITELIST_DOMAIN WHERE C_ASSESSMENT_ID=?";
			
			ArrayList<DomainDetails> Domain = new ArrayList<DomainDetails>();

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, assessmentID);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("C_ID");
				String domainName = rs.getString("C_DOMAIN_NAME");
				String lecturerID = rs.getString("C_LECTURER_ID");

				DomainDetails dd = new DomainDetails(id, domainName, lecturerID);
				Domain.add(dd);
			}
			conn.close();
			return Domain; 
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
