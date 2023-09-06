package com.zlennon.openfeign;

import com.zlennon.commonentity.ReqResItemsEntity;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class LiveTest {
    private final String ROOT_URI = "http://localhost:7100";

    @Test
    public void accessChatGPTEndpoint() {
        final Response response = RestAssured.given()
                .get(ROOT_URI + "/openfeign/getChatGPTById?id=5");
        Assert.assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        Assert.assertNotNull(response.getBody());
        final ReqResItemsEntity result = response.as(ReqResItemsEntity.class);
        Assert.assertEquals(new Long(5), result.getChatId());
    }
}
