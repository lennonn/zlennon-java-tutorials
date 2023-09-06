package com.zlennon.springwebserviceserver;

import jakarta.xml.bind.JAXBElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.namespace.QName;


@Endpoint
public class CountryEndpoint {
    private static final String NAMESPACE_URI = "http://zlennon.com/webservices/country";

    @Autowired
    CountryRepository countryRepository;
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public JAXBElement getCountry(@RequestPayload GetCountryRequest request) {
      //  Country country = countryRepository.findCountry(request.getName());
        Country country = countryRepository.findCountry("Spain");
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(country);
        return createJaxbElement(response,GetCountryResponse.class);
       // return response;
    }


    private <T> JAXBElement<T> createJaxbElement(T object, Class<T> clazz) {
        return new JAXBElement<>(new QName(clazz.getSimpleName()), clazz, object);
    }
}

