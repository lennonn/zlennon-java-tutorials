package com.zlennon.authorizationserver.user;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="sys_user")
@Data
public class SysUser {
    @Id
    private Long id;
    private String username;
    private String password;
    private String email;

}
