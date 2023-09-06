package com.zlennon.collections;


import com.alibaba.fastjson2.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestAddAttr {
    private List<LastInfo> infos = new ArrayList<>();

    public List<LastInfo> getInfos() {
        return infos;
    }

    public void setInfos(List<LastInfo> infos) {
        this.infos = infos;
    }

    public  void testContain(){
        String id ="a1";
        LastInfo lastInfo= infos.stream().filter(i->i.getId().equals("a1")).findFirst().orElse(null);
        if(lastInfo==null){
            lastInfo = new LastInfo();
            lastInfo.setId("a1");
            lastInfo.setAvgDof("avg_new");
            lastInfo.setAvgSse("sse_new");
            infos.add(lastInfo);
        }else{
            lastInfo.setAvgDof("avg_old");
            lastInfo.setAvgSse("sse_old");
        }
        addItemtoList(infos);
        Assert.assertEquals(2,infos.size());
        System.out.println(JSONObject.toJSONString(infos));

    }

    @Test
    public  void testAdd(){
        TestAddAttr testAddAttr = new TestAddAttr();
        testAddAttr.testContain();
    }

    void addItemtoList( List<LastInfo> infos){
        LastInfo  lastInfo = new LastInfo();
        lastInfo.setId("a3");
        lastInfo.setAvgDof("22");
        lastInfo.setAvgSse("345");
        infos.add(lastInfo);
    }

    @Test
    public void testListAddAll(){
        List<String> list1 = Collections.EMPTY_LIST;
        List<String> list2 =new ArrayList<>();
        list2.add("sdfdsf");
        list1.addAll(list2);
        Collections.emptyList();
    }
}
