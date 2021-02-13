//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.02.08 at 10:41:17 AM IST 
//


package com.htc.jaxb.helpers;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.htc.jaxb.helpers package. 
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

    private final static QName _Hospital_QNAME = new QName("http://www.htc.com/hospital", "hospital");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.htc.jaxb.helpers
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HospitalTy }
     * 
     */
    public HospitalTy createHospitalTy() {
        return new HospitalTy();
    }

    /**
     * Create an instance of {@link DoctorTy }
     * 
     */
    public DoctorTy createDoctorTy() {
        return new DoctorTy();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HospitalTy }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.htc.com/hospital", name = "hospital")
    public JAXBElement<HospitalTy> createHospital(HospitalTy value) {
        return new JAXBElement<HospitalTy>(_Hospital_QNAME, HospitalTy.class, null, value);
    }

}
