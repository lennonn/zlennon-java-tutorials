## springboot
### spirng-webservice
    port:5003
    http://localhost:5003/ws/countries.wsdl
### spring-recator
    port:9020
    http://localhost:9020/model/ada
### spring-secuirty
####  auth-server
    port:8200
    http://localhost:8200
####  jwt-security
    port:8201
    http://localhost:8201
####  oauth2-client
    port:8300
    http://localhost:8300
####  oauth2-login
    port:8302
    http://localhost:8302
####  oauth2-resource
    port:8301
    http://localhost:8301
####  oauth2-webclient
    port:8304
    http://localhost:8304

## spring-cloud
### spirng-cloud-bus
    port:7005
    http://localhost:7005/actuator/busrefresh
### spring-cloud-openfeign
    port:7100
    http://localhost:7100/openfeign/getChatGPTById?id=5
### spring-cloud-circuitbreaker
    port:7200
    http://localhost:7200/circuitbreaker/getAllModel
    http://localhost:7200/circuitbreaker/getChatGPTById/davinci
    http://localhost:7200/actuator/health
### spring-cloud-gateway
    port:7999

### chatgpt-api-service
    port:7999
    http://localhost:7999/chatgpt/getChatGPTById/5
    http://127.0.0.1:7999/chatgpt/getAllModel

### chatgpt-model-service
    port:7888

### spring-cloud-config-client
    port:7004
    获取配置：restapi: http://localhost:7004/getConfig
    配置刷新：http://localhost:7004/actuator/refresh
### spring-cloud-config-server
    port:7003


## 2023/04/02 
  * spirngboot 2.7.2 to springboot 3.0
  * javax.servlet->jakarta.servlet (2018 年，Java EE 改名为 Jakarta EE)
  * jakarta.persistence->jakarta.persistence
  * org.springframework.boot.web.server.LocalServerPort -> org.springframework.boot.test.web.server.LocalServerPort
