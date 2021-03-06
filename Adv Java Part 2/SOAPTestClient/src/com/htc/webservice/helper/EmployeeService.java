
package com.htc.webservice.helper;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "EmployeeService", targetNamespace = "http://webservice.htc.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface EmployeeService {


    /**
     * 
     * @param emp
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(name = "employee", targetNamespace = "")
    @RequestWrapper(localName = "addEmployee", targetNamespace = "http://webservice.htc.com/", className = "com.htc.webservice.helper.AddEmployee")
    @ResponseWrapper(localName = "addEmployeeResponse", targetNamespace = "http://webservice.htc.com/", className = "com.htc.webservice.helper.AddEmployeeResponse")
    @Action(input = "http://webservice.htc.com/EmployeeService/addEmployeeRequest", output = "http://webservice.htc.com/EmployeeService/addEmployeeResponse")
    public boolean addEmployee(
        @WebParam(name = "emp", targetNamespace = "")
        Employee emp);

    /**
     * 
     * @param arg2
     * @param testMarks
     * @param arg1
     * @return
     *     returns java.util.List<com.htc.webservice.helper.Employee>
     */
    @WebMethod
    @WebResult(name = "eligiblity", targetNamespace = "")
    @RequestWrapper(localName = "eligibleEmp", targetNamespace = "http://webservice.htc.com/", className = "com.htc.webservice.helper.EligibleEmp")
    @ResponseWrapper(localName = "eligibleEmpResponse", targetNamespace = "http://webservice.htc.com/", className = "com.htc.webservice.helper.EligibleEmpResponse")
    @Action(input = "http://webservice.htc.com/EmployeeService/eligibleEmpRequest", output = "http://webservice.htc.com/EmployeeService/eligibleEmpResponse")
    public List<Employee> eligibleEmp(
        @WebParam(name = "testMarks", targetNamespace = "")
        String testMarks,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2);

    /**
     * 
     * @param empno
     * @return
     *     returns com.htc.webservice.helper.Employee
     */
    @WebMethod
    @WebResult(name = "employeeId", targetNamespace = "")
    @RequestWrapper(localName = "getEmployee", targetNamespace = "http://webservice.htc.com/", className = "com.htc.webservice.helper.GetEmployee")
    @ResponseWrapper(localName = "getEmployeeResponse", targetNamespace = "http://webservice.htc.com/", className = "com.htc.webservice.helper.GetEmployeeResponse")
    @Action(input = "http://webservice.htc.com/EmployeeService/getEmployeeRequest", output = "http://webservice.htc.com/EmployeeService/getEmployeeResponse")
    public Employee getEmployee(
        @WebParam(name = "empno", targetNamespace = "")
        String empno);

}
