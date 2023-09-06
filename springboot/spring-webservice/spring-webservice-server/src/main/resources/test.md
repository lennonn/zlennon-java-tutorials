---soapui request ---
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:coun="http://zlennon.com/webservices/country">
    <soapenv:Header/>
    <soapenv:Body>
        <coun:getCountryRequest>
            <coun:name>United Kingdom</coun:name>
        </coun:getCountryRequest>
    </soapenv:Body>
</soapenv:Envelope>
        
---soapui respones ---
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
<SOAP-ENV:Header/>
<SOAP-ENV:Body>
<GetCountryResponse xmlns:ns2="http://zlennon.com/webservices/country">
<ns2:country>
<ns2:name>United Kingdom</ns2:name>
<ns2:population>63705000</ns2:population>
<ns2:capital>London</ns2:capital>
<ns2:currency>GBP</ns2:currency>
</ns2:country>
</GetCountryResponse>
</SOAP-ENV:Body>
</SOAP-ENV:Envelope>