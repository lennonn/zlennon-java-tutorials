package com.zlennon.springwebserviceclient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.ws.client.core.WebServiceTemplate;


import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CountryClientConfig.class, loader = AnnotationConfigContextLoader.class)
public class CountryClientLiveTest {

   @Autowired
    CountryClient client;

    @Test
    public void givenCountryService_whenCountryPoland_thenCapitalIsWarsaw() {
       GetCountryResponse response = client.getCountry("http://localhost:5003/ws","Poland");
       assertEquals("Warsaw", response.getCountry()
            .getCapital());
    }

    @Test
    public void givenCountryService_whenCountrySpain_thenCurrencyEUR() {
        GetCountryResponse response = client.getCountry("http://localhost:5003/ws","Spain");
        assertEquals(Currency.EUR, response.getCountry()
            .getCurrency());
    }

    @Test
    public void test(){
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setDefaultUri("http://localhost:5003/ws");
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        //marshaller.setPackagesToScan("com.zlennon.springwebserviceclient");
        marshaller.setContextPath("com.zlennon.springwebserviceclient");
        webServiceTemplate.setMarshaller(marshaller);
        webServiceTemplate.setUnmarshaller(marshaller);
        GetCountryRequest request = new GetCountryRequest();
        request.setName("Spain");
        GetCountryResponse response = new GetCountryResponse();
        Object o = webServiceTemplate.marshalSendAndReceive("http://localhost:5003/ws",
                request);

    }
}
