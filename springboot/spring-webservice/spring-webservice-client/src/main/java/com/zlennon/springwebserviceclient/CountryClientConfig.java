package com.zlennon.springwebserviceclient;

import jakarta.xml.bind.JAXBException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CountryClientConfig {

   @Bean
    public Jaxb2Marshaller marshaller() {
            Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
            //marshaller.setPackagesToScan("com.zlennon.springwebserviceclient");
            marshaller.setContextPath("com.zlennon.springwebserviceclient");
            return marshaller;
    }

    @Bean
    public Jaxb2Marshaller unmarshaller() throws JAXBException {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.zlennon.springwebserviceclient");
        //marshaller.setContextPath("com.zlennon.springwebserviceclient");
        return marshaller;
    }

    @Bean
    public CountryClient countryClient(Jaxb2Marshaller marshaller) throws JAXBException {
            CountryClient client = new CountryClient();
            client.setDefaultUri("http://localhost:5003/ws");
            client.setMarshaller(marshaller);
            client.setUnmarshaller(marshaller);
            return client;
    }



}