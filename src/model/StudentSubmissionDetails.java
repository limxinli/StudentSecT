package model;

public class StudentSubmissionDetails {
	private int id;
	private String adminNo;
	private String uCode;
	private String fileName;
	private int version;
	private int assessmentId;
	
	public StudentSubmissionDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentSubmissionDetails(int id, String adminNo, String uCode, String fileName, int version, int assessmentId) {
		super();
		this.id = id;
		this.adminNo = adminNo;
		this.uCode = uCode;
		this.fileName = fileName;
		this.version = version;
		this.assessmentId = assessmentId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdminNo() {
		return adminNo;
	}

	public void setAdminNo(String adminNo) {
		this.adminNo = adminNo;
	}

	public String getuCode() {
		return uCode;
	}

	public void setuCode(String uCode) {
		this.uCode = uCode;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(int assessmentId) {
		this.assessmentId = assessmentId;
	}

}
