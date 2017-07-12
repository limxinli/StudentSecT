package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import db.*;

public class AnnouncementManager{
	public static ArrayList<AnnouncementDetails> retrieveAnnouncement(String assessmentID) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "SELECT * FROM T_ANNOUNCEMENT WHERE C_ASSESSMENT_ID=? ORDER BY C_TIMESTAMP DESC";
			
			ArrayList<AnnouncementDetails> Announcement = new ArrayList<AnnouncementDetails>();

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, assessmentID);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String moduleCode = rs.getString("C_MODULE_CODE");
				String lecturerName = rs.getString("C_LECTURER_NAME");
				String announcement = rs.getString("C_ANNOUNCEMENT");
				Timestamp timestamp = rs.getTimestamp("C_TIMESTAMP");
				int assessmentId = rs.getInt("C_ASSESSMENT_ID");

				AnnouncementDetails ad = new AnnouncementDetails(moduleCode, lecturerName, announcement, timestamp, assessmentId);
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
