package model;

public class AssessmentDetails {
	private String moduleCode;
	private String moduleName;
	private String lecturerID;
	private int period;
	private String datetime;
	private String examCode;
	
	public AssessmentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AssessmentDetails(String moduleCode, String moduleName, String lecturerID, int period, String datetime,
			String examCode) {
		super();
		this.moduleCode = moduleCode;
		this.moduleName = moduleName;
		this.lecturerID = lecturerID;
		this.period = period;
		this.datetime = datetime;
		this.examCode = examCode;
	}

	public AssessmentDetails(String moduleCode, String moduleName, int period, String datetime, String examCode) {
		super();
		this.moduleCode = moduleCode;
		this.moduleName = moduleName;
		this.period = period;
		this.datetime = datetime;
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

	public String getLecturerID() {
		return lecturerID;
	}

	public void setLecturerID(String lecturerID) {
		this.lecturerID = lecturerID;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getExamCode() {
		return examCode;
	}

	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}

}
