package model;

public class FileDetails {
	private String moduleCode;
	private String examCode;
	private String fileName;
	private String fileLink;
	
	public FileDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileDetails(String moduleCode, String examCode, String fileName, String fileLink) {
		super();
		this.moduleCode = moduleCode;
		this.examCode = examCode;
		this.fileName = fileName;
		this.fileLink = fileLink;
	}

	public FileDetails(String fileName, String fileLink) {
		super();
		this.fileName = fileName;
		this.fileLink = fileLink;
	}

	public String getModuleCode() {
		return moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	public String getExamCode() {
		return examCode;
	}

	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileLink() {
		return fileLink;
	}

	public void setFileLink(String fileLink) {
		this.fileLink = fileLink;
	}
	
}
