package model;

import java.sql.Timestamp;

public class AnnouncementDetails {
	private String moduleCode;
	private String moduleName;
	private String lecturerName;
	private String announcement;
	private Timestamp timestamp;
	private String examCode;
	
	public AnnouncementDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnnouncementDetails(String moduleCode, String moduleName, String lecturerName, String announcement,
			Timestamp timestamp, String examCode) {
		super();
		this.moduleCode = moduleCode;
		this.moduleName = moduleName;
		this.lecturerName = lecturerName;
		this.announcement = announcement;
		this.timestamp = timestamp;
		this.examCode = examCode;
	}

	public String getModuleCode() {
		return moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
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

	public String getExamCode() {
		return examCode;
	}

	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}
	
}
