package com.htc.webservice;


import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface EmployeeService
{
	@WebMethod(operationName="getEmployee")
	public @WebResult(name="employeeId") Employee getEmployee(@WebParam(name="empno") String employeeId);

	@WebMethod(operationName ="addEmployee")
	public @WebResult(name="employee") boolean addNewEmployee(@WebParam(name="emp") Employee emp);
	
	@WebMethod(operationName ="eligibleEmp")
	public @WebResult(name="eligiblity")List<Employee> getEligibleEmp(@WebParam(name="testMarks") String testMarks,String interviewMarks,String softSkillMarks);
	
}	
