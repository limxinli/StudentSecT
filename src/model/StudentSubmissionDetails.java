package model;

public class StudentSubmissionDetails {
	private int id;
	private String adminNo;
	private String uCode;
	
	public StudentSubmissionDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentSubmissionDetails(int id, String adminNo, String uCode) {
		super();
		this.id = id;
		this.adminNo = adminNo;
		this.uCode = uCode;
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

	public String getUCode() {
		return uCode;
	}

	public void setUCode(String uCode) {
		this.uCode = uCode;
	}

}
