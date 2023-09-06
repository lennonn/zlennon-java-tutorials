package com.zlennon.chatgptmodelservice.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "model")
@Entity
@Data
public class Model implements Serializable {
    @Id
    public String id;
    public String object;
    public String ownedBy;
    @OneToMany(mappedBy ="model",cascade = CascadeType.REMOVE)
    public List<Permission> permission;
    public String root;
    public String parent;

    public Model() {
    }


}