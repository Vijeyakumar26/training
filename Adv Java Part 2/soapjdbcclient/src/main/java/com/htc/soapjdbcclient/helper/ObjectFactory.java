
package com.htc.soapjdbcclient.helper;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.htc.soapjdbcclient.helper package. 
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

    private final static QName _GetTouristPlaceDetails_QNAME = new QName("http://service.soapjdbc.htc.com/", "getTouristPlaceDetails");
    private final static QName _GetTouristPlaceDetailsResponse_QNAME = new QName("http://service.soapjdbc.htc.com/", "getTouristPlaceDetailsResponse");
    private final static QName _GetAllTouristPlaces_QNAME = new QName("http://service.soapjdbc.htc.com/", "getAllTouristPlaces");
    private final static QName _GetAllTouristPlacesResponse_QNAME = new QName("http://service.soapjdbc.htc.com/", "getAllTouristPlacesResponse");
    private final static QName _TouristPlace_QNAME = new QName("http://service.soapjdbc.htc.com/", "touristPlace");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.htc.soapjdbcclient.helper
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TouristPlace }
     * 
     */
    public TouristPlace createTouristPlace() {
        return new TouristPlace();
    }

    /**
     * Create an instance of {@link GetTouristPlaceDetailsResponse }
     * 
     */
    public GetTouristPlaceDetailsResponse createGetTouristPlaceDetailsResponse() {
        return new GetTouristPlaceDetailsResponse();
    }

    /**
     * Create an instance of {@link GetTouristPlaceDetails }
     * 
     */
    public GetTouristPlaceDetails createGetTouristPlaceDetails() {
        return new GetTouristPlaceDetails();
    }

    /**
     * Create an instance of {@link GetAllTouristPlaces }
     * 
     */
    public GetAllTouristPlaces createGetAllTouristPlaces() {
        return new GetAllTouristPlaces();
    }

    /**
     * Create an instance of {@link GetAllTouristPlacesResponse }
     * 
     */
    public GetAllTouristPlacesResponse createGetAllTouristPlacesResponse() {
        return new GetAllTouristPlacesResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTouristPlaceDetails }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soapjdbc.htc.com/", name = "getTouristPlaceDetails")
    public JAXBElement<GetTouristPlaceDetails> createGetTouristPlaceDetails(GetTouristPlaceDetails value) {
        return new JAXBElement<GetTouristPlaceDetails>(_GetTouristPlaceDetails_QNAME, GetTouristPlaceDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTouristPlaceDetailsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soapjdbc.htc.com/", name = "getTouristPlaceDetailsResponse")
    public JAXBElement<GetTouristPlaceDetailsResponse> createGetTouristPlaceDetailsResponse(GetTouristPlaceDetailsResponse value) {
        return new JAXBElement<GetTouristPlaceDetailsResponse>(_GetTouristPlaceDetailsResponse_QNAME, GetTouristPlaceDetailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllTouristPlaces }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soapjdbc.htc.com/", name = "getAllTouristPlaces")
    public JAXBElement<GetAllTouristPlaces> createGetAllTouristPlaces(GetAllTouristPlaces value) {
        return new JAXBElement<GetAllTouristPlaces>(_GetAllTouristPlaces_QNAME, GetAllTouristPlaces.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllTouristPlacesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soapjdbc.htc.com/", name = "getAllTouristPlacesResponse")
    public JAXBElement<GetAllTouristPlacesResponse> createGetAllTouristPlacesResponse(GetAllTouristPlacesResponse value) {
        return new JAXBElement<GetAllTouristPlacesResponse>(_GetAllTouristPlacesResponse_QNAME, GetAllTouristPlacesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TouristPlace }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soapjdbc.htc.com/", name = "touristPlace")
    public JAXBElement<TouristPlace> createTouristPlace(TouristPlace value) {
        return new JAXBElement<TouristPlace>(_TouristPlace_QNAME, TouristPlace.class, null, value);
    }

}
