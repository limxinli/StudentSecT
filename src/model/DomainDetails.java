package model;

public class DomainDetails {
	private int id;
	private String domainName;
	private String lecturerID;
	
	public DomainDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DomainDetails(int id, String domainName, String lecturerID) {
		super();
		this.id = id;
		this.domainName = domainName;
		this.lecturerID = lecturerID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getLecturerID() {
		return lecturerID;
	}

	public void setLecturerID(String lecturerID) {
		this.lecturerID = lecturerID;
	}

}
