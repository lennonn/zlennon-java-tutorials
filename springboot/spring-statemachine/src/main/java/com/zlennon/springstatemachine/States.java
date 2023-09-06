package com.zlennon.springstatemachine;

public enum States {
    away("离开"),
    prepare( "准备中"),
    busy("示忙"),
    brief( "小结"),
    ready( "就绪"),
    calling( "振铃中"),
    service( "服务中"),
    closed("会话结束");


    private String desc;

    States(String desc) {
        this.desc =desc;
    }
}
