package com.zlennon.springstatemachine;

public enum Events {
    checkIn("checkIn", "签入"),
    checkOut("checkOut", "签出"),
    login("login", "登录"),
    ready("ready", "就绪"),
    leave("leave", "示忙"),
    callin("callin", "振铃"),
    closeSession("closeSession", "关闭会话"),
    logout("logout", "退出");


    private String action;
    private String name;

    Events(String action, String name) {
        this.action = action;
        this.name = name;
    }
}
