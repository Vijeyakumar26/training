package com.htc.webservice;

public class Employee
{
	private String employeeId; 
	private String employeeName;
	private String testMarks;
	private String interviewMarks;
	private String softSkillMarks;
	
	public Employee() {
		super();
	}

	public Employee(String employeeId, String employeeName, String testMarks, String interviewMarks,
			String softSkillMarks) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.testMarks = testMarks;
		this.interviewMarks = interviewMarks;
		this.softSkillMarks = softSkillMarks;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getTestMarks() {
		return testMarks;
	}

	public void setTestMarks(String testMarks) {
		this.testMarks = testMarks;
	}

	public String getInterviewMarks() {
		return interviewMarks;
	}

	public void setInterviewMarks(String interviewMarks) {
		this.interviewMarks = interviewMarks;
	}

	public String getSoftSkillMarks() {
		return softSkillMarks;
	}

	public void setSoftSkillMarks(String softSkillMarks) {
		this.softSkillMarks = softSkillMarks;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", testMarks=" + testMarks
				+ ", interviewMarks=" + interviewMarks + ", softSkillMarks=" + softSkillMarks + "]";
	}
	
}
