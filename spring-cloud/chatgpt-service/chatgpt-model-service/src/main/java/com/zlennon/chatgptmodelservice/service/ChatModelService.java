package com.zlennon.chatgptmodelservice.service;

import cn.hutool.Hutool;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.TypeReference;
import com.zlennon.chatgptmodelservice.entity.Model;
import com.zlennon.chatgptmodelservice.entity.Permission;
import com.zlennon.chatgptmodelservice.repository.ModelRepository;
import com.zlennon.chatgptmodelservice.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatModelService {

    @Autowired
    ModelRepository modelRepository;

    @Autowired
    PermissionRepository permissionRepository;

    public void execute() {

        HttpResponse response = HttpUtil.createPost("http://127.0.0.1:7999" + "/chatgpt/getAllModel").execute();
        if(response.getStatus()==200){
            List<Model> list = JSON.parseObject(response.body(), new TypeReference<List<Model>>(){});
            list.forEach(c->{
                List<Permission> permission = c.getPermission();
                permission.forEach(p->{
                    p.setModel(c);
                });
                permissionRepository.saveAll(permission);
            });
            modelRepository.saveAll(list);

        }
    }
}
