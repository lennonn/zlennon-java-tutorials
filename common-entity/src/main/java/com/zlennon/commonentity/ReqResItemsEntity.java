package com.zlennon.commonentity;


import lombok.Data;

import java.util.Objects;

@Data
public class ReqResItemsEntity {
    private Integer chatId;
    private String reqInfo;
    private String resInfo;
    private String api;
    private Integer type;
}
