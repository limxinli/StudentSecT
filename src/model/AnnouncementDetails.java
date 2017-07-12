package model;

import java.sql.Timestamp;

public class AnnouncementDetails {
	private String moduleCode;
	private String lecturerName;
	private String announcement;
	private Timestamp timestamp;
	private int assessmentId;
	
	public AnnouncementDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnnouncementDetails(String moduleCode, String lecturerName, String announcement, Timestamp timestamp,
			int assessmentId) {
		super();
		this.moduleCode = moduleCode;
		this.lecturerName = lecturerName;
		this.announcement = announcement;
		this.timestamp = timestamp;
		this.assessmentId = assessmentId;
	}

	public String getModuleCode() {
		return moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	public String getLecturerName() {
		return lecturerName;
	}

	public void setLecturerName(String lecturerName) {
		this.lecturerName = lecturerName;
	}

	public String getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(String announcement) {
		this.announcement = announcement;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public int getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(int assessmentId) {
		this.assessmentId = assessmentId;
	}

}
