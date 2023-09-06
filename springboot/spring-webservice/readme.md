**由于 使用的是   javax.xml.bind.annotation  非jakarta.xml.bind.annotation
导致以下异常**

Caused by: jakarta.xml.bind.JAXBException: class com.zlennon.springwebserviceclient.GetCountryRequest以及其任何超类对此上下文都是未知的。
Caused by: jakarta.xml.bind.UnmarshalException: 意外的元素 (uri:"", local:"GetCountryResponse")所需元素为
<faultstring xml:lang="en">No adapter for endpoint [public javax.xml.bind.JAXBElement&lt;com.zlennon.springwebserviceserver.GetCountryResponse> com.zlennon.springwebserviceserver.CountryEndpoint.getCountry(javax.xml.bind.JAXBElement&lt;com.zlennon.springwebserviceserver.GetCountryRequest>)]: Is your endpoint annotated with @Endpoint, or does it implement a supported interface like MessageHandler or PayloadEndpoint?</faultstring>
https://stackoverflow.com/questions/14390474/no-adapter-for-endpoint-is-your-endpoint-annotated-with-endpoint-or-does-it-i
