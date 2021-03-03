
package com.htc.webservice.helper;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getTouristPlaceDetailsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getTouristPlaceDetailsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="touristPlace" type="{http://webservice.htc.com/}touristPlace" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getTouristPlaceDetailsResponse", propOrder = {
    "touristPlace"
})
public class GetTouristPlaceDetailsResponse {

    protected TouristPlace touristPlace;

    /**
     * Gets the value of the touristPlace property.
     * 
     * @return
     *     possible object is
     *     {@link TouristPlace }
     *     
     */
    public TouristPlace getTouristPlace() {
        return touristPlace;
    }

    /**
     * Sets the value of the touristPlace property.
     * 
     * @param value
     *     allowed object is
     *     {@link TouristPlace }
     *     
     */
    public void setTouristPlace(TouristPlace value) {
        this.touristPlace = value;
    }

}
