
package com.htc.webservice.helper;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.htc.webservice.helper package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddEmployeeResponse_QNAME = new QName("http://webservice.htc.com/", "addEmployeeResponse");
    private final static QName _EligibleEmpResponse_QNAME = new QName("http://webservice.htc.com/", "eligibleEmpResponse");
    private final static QName _AddEmployee_QNAME = new QName("http://webservice.htc.com/", "addEmployee");
    private final static QName _GetEmployeeResponse_QNAME = new QName("http://webservice.htc.com/", "getEmployeeResponse");
    private final static QName _GetEmployee_QNAME = new QName("http://webservice.htc.com/", "getEmployee");
    private final static QName _EligibleEmp_QNAME = new QName("http://webservice.htc.com/", "eligibleEmp");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.htc.webservice.helper
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetEmployee }
     * 
     */
    public GetEmployee createGetEmployee() {
        return new GetEmployee();
    }

    /**
     * Create an instance of {@link EligibleEmp }
     * 
     */
    public EligibleEmp createEligibleEmp() {
        return new EligibleEmp();
    }

    /**
     * Create an instance of {@link AddEmployeeResponse }
     * 
     */
    public AddEmployeeResponse createAddEmployeeResponse() {
        return new AddEmployeeResponse();
    }

    /**
     * Create an instance of {@link EligibleEmpResponse }
     * 
     */
    public EligibleEmpResponse createEligibleEmpResponse() {
        return new EligibleEmpResponse();
    }

    /**
     * Create an instance of {@link AddEmployee }
     * 
     */
    public AddEmployee createAddEmployee() {
        return new AddEmployee();
    }

    /**
     * Create an instance of {@link GetEmployeeResponse }
     * 
     */
    public GetEmployeeResponse createGetEmployeeResponse() {
        return new GetEmployeeResponse();
    }

    /**
     * Create an instance of {@link Employee }
     * 
     */
    public Employee createEmployee() {
        return new Employee();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddEmployeeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.htc.com/", name = "addEmployeeResponse")
    public JAXBElement<AddEmployeeResponse> createAddEmployeeResponse(AddEmployeeResponse value) {
        return new JAXBElement<AddEmployeeResponse>(_AddEmployeeResponse_QNAME, AddEmployeeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EligibleEmpResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.htc.com/", name = "eligibleEmpResponse")
    public JAXBElement<EligibleEmpResponse> createEligibleEmpResponse(EligibleEmpResponse value) {
        return new JAXBElement<EligibleEmpResponse>(_EligibleEmpResponse_QNAME, EligibleEmpResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddEmployee }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.htc.com/", name = "addEmployee")
    public JAXBElement<AddEmployee> createAddEmployee(AddEmployee value) {
        return new JAXBElement<AddEmployee>(_AddEmployee_QNAME, AddEmployee.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmployeeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.htc.com/", name = "getEmployeeResponse")
    public JAXBElement<GetEmployeeResponse> createGetEmployeeResponse(GetEmployeeResponse value) {
        return new JAXBElement<GetEmployeeResponse>(_GetEmployeeResponse_QNAME, GetEmployeeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmployee }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.htc.com/", name = "getEmployee")
    public JAXBElement<GetEmployee> createGetEmployee(GetEmployee value) {
        return new JAXBElement<GetEmployee>(_GetEmployee_QNAME, GetEmployee.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EligibleEmp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.htc.com/", name = "eligibleEmp")
    public JAXBElement<EligibleEmp> createEligibleEmp(EligibleEmp value) {
        return new JAXBElement<EligibleEmp>(_EligibleEmp_QNAME, EligibleEmp.class, null, value);
    }

}
