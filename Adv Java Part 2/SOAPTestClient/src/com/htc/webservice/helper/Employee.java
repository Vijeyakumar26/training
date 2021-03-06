
package com.htc.webservice.helper;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for employee complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="employee">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="employeeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="employeeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="interviewMarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="softSkillMarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="testMarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "employee", propOrder = {
    "employeeId",
    "employeeName",
    "interviewMarks",
    "softSkillMarks",
    "testMarks"
})
public class Employee {

    protected String employeeId;
    protected String employeeName;
    protected String interviewMarks;
    protected String softSkillMarks;
    protected String testMarks;

    /**
     * Gets the value of the employeeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets the value of the employeeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmployeeId(String value) {
        this.employeeId = value;
    }

    /**
     * Gets the value of the employeeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * Sets the value of the employeeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmployeeName(String value) {
        this.employeeName = value;
    }

    /**
     * Gets the value of the interviewMarks property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterviewMarks() {
        return interviewMarks;
    }

    /**
     * Sets the value of the interviewMarks property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterviewMarks(String value) {
        this.interviewMarks = value;
    }

    /**
     * Gets the value of the softSkillMarks property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSoftSkillMarks() {
        return softSkillMarks;
    }

    /**
     * Sets the value of the softSkillMarks property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSoftSkillMarks(String value) {
        this.softSkillMarks = value;
    }

    /**
     * Gets the value of the testMarks property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTestMarks() {
        return testMarks;
    }

    /**
     * Sets the value of the testMarks property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTestMarks(String value) {
        this.testMarks = value;
    }

}
