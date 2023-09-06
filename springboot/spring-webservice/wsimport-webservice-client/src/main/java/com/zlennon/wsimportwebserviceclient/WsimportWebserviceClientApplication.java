package com.zlennon.wsimportwebserviceclient;

import com.zlennon.wsimportwebserviceclient.country.CountriesPort;
import com.zlennon.wsimportwebserviceclient.country.CountriesPortService;
import com.zlennon.wsimportwebserviceclient.country.GetCountryRequest;
import com.zlennon.wsimportwebserviceclient.country.GetCountryResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WsimportWebserviceClientApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(WsimportWebserviceClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        CountriesPortService service = new CountriesPortService();
        CountriesPort countriesPortSoap11 = service.getCountriesPortSoap11();

        GetCountryRequest request = new GetCountryRequest();
        request.setName("Spain");
        GetCountryResponse country = countriesPortSoap11.getCountry(request);
        System.out.println(country.toString());
    }
}
