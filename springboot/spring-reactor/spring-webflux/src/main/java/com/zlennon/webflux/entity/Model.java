package com.zlennon.webflux.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.Id;

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