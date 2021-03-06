package com.htc.webservice.resource;

public class Organisation
{
	private String orgId;
	private String organizationName;
	private String address;
	private String landlineno;
	private String contactPerson;
	private String emailId;
	
	@Override
	public String toString() {
		return "Organisation [orgId=" + orgId + ", organizationName=" + organizationName + ", address=" + address
				+ ", landlineno=" + landlineno + ", contactPerson=" + contactPerson + ", emailId=" + emailId + "]";
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLandlineno() {
		return landlineno;
	}

	public void setLandlineno(String landlineno) {
		this.landlineno = landlineno;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Organisation(String orgId, String organizationName, String address, String landlineno, String contactPerson,
			String emailId) {
		super();
		this.orgId = orgId;
		this.organizationName = organizationName;
		this.address = address;
		this.landlineno = landlineno;
		this.contactPerson = contactPerson;
		this.emailId = emailId;
	}

	public Organisation() {
		super();
	}
	
	
}
