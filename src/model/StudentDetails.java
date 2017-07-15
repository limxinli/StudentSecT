package model;

public class StudentDetails {
	private String adminNo;
	private String ipAddr;
	private String portNo;
	private String timestamp;
	private String uniqueCode;
	private int submitDisable;
	private int cheating;
	private int disconnected;
	private int assessmentId;
	
	public StudentDetails() {
		super();
	}

	public StudentDetails(String adminNo, String ipAddr, String portNo, String timestamp, String uniqueCode,
			int submitDisable, int cheating, int disconnected, int assessmentId) {
		super();
		this.adminNo = adminNo;
		this.ipAddr = ipAddr;
		this.portNo = portNo;
		this.timestamp = timestamp;
		this.uniqueCode = uniqueCode;
		this.submitDisable = submitDisable;
		this.cheating = cheating;
		this.disconnected = disconnected;
		this.assessmentId = assessmentId;
	}

	public StudentDetails(String adminNo, String ipAddr, String portNo, String timestamp, String uniqueCode,
			int submitDisable, int cheating, int disconnected) {
		super();
		this.adminNo = adminNo;
		this.ipAddr = ipAddr;
		this.portNo = portNo;
		this.timestamp = timestamp;
		this.uniqueCode = uniqueCode;
		this.submitDisable = submitDisable;
		this.cheating = cheating;
		this.disconnected = disconnected;
	}

	public String getAdminNo() {
		return adminNo;
	}

	public void setAdminNo(String adminNo) {
		this.adminNo = adminNo;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getPortNo() {
		return portNo;
	}

	public void setPortNo(String portNo) {
		this.portNo = portNo;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getUniqueCode() {
		return uniqueCode;
	}

	public void setUniqueCode(String uniqueCode) {
		this.uniqueCode = uniqueCode;
	}

	public int getSubmitDisable() {
		return submitDisable;
	}

	public void setSubmitDisable(int submitDisable) {
		this.submitDisable = submitDisable;
	}

	public int getCheating() {
		return cheating;
	}

	public void setCheating(int cheating) {
		this.cheating = cheating;
	}

	public int getDisconnected() {
		return disconnected;
	}

	public void setDisconnected(int disconnected) {
		this.disconnected = disconnected;
	}

	public int getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(int assessmentId) {
		this.assessmentId = assessmentId;
	}

}
