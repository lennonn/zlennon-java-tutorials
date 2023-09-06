
package com.zlennon.wsimportwebserviceclient.country;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CountriesPort", targetNamespace = "http://zlennon.com/webservices/country")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CountriesPort {


    /**
     * 
     * @param getCountryRequest
     * @return
     *     returns com.zlennon.webservices.country.GetCountryResponse
     */
    @WebMethod
    @WebResult(name = "getCountryResponse", targetNamespace = "http://zlennon.com/webservices/country", partName = "getCountryResponse")
    public GetCountryResponse getCountry(
        @WebParam(name = "getCountryRequest", targetNamespace = "http://zlennon.com/webservices/country", partName = "getCountryRequest")
        GetCountryRequest getCountryRequest);

}
