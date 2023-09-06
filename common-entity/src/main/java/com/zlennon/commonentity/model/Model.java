package com.zlennon.commonentity.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class Model implements Serializable {
    public String id;
    public String object;
    public String ownedBy;
    public List<Permission> permission;
    public String root;
    public String parent;

    public Model() {
    }


}