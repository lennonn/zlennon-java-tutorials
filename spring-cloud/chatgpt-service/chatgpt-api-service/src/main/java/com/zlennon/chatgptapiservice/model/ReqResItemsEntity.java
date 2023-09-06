package com.zlennon.chatgptapiservice.model;


import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "req_res_items", catalog = "")
public class ReqResItemsEntity {
    private Integer chatId;
    private String reqInfo;
    private String resInfo;
    private String api;
    private Integer type;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_id")
    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }



    @Column(name = "req_info")
    public String getReqInfo() {
        return reqInfo;
    }

    public void setReqInfo(String reqInfo) {
        this.reqInfo = reqInfo;
    }

    @Column(name = "res_info")
    public String getResInfo() {
        return resInfo;
    }

    public void setResInfo(String resInfo) {
        this.resInfo = resInfo;
    }

    @Column(name = "api")
    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReqResItemsEntity that = (ReqResItemsEntity) o;
        return Objects.equals(chatId, that.chatId) && Objects.equals(reqInfo, that.reqInfo) && Objects.equals(resInfo, that.resInfo) && Objects.equals(api, that.api) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chatId, reqInfo, resInfo, api, type);
    }
}
