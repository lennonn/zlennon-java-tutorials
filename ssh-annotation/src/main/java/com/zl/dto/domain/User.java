package com.zl.dto.domain;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_USER", schema = "SCOTT")
@Component
public class User implements java.io.Serializable {

	// Fields

	private String userId;
	private String name;
	private Timestamp registerTime;
	private String password;
	private String lastLoginTime;
	private String loginTime;
	private String loginIp;
	private String remark;
	private String repassword;

	// Constructors


	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String name, Timestamp registerTime, String password,
			String lastLoginTime, String loginTime, String loginIp,
			String remark) {
		this.name = name;
		this.registerTime = registerTime;
		this.password = password;
		this.lastLoginTime = lastLoginTime;
		this.loginTime = loginTime;
		this.loginIp = loginIp;
		this.remark = remark;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "USER_ID", unique = true, nullable = false, length = 128)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "NAME", length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "REGISTER_TIME")
	public Timestamp getRegisterTime() {
		return this.registerTime;
	}

	public void setRegisterTime(Timestamp timestamp) {
		this.registerTime = timestamp;
	}

	@Column(name = "PASSWORD", length = 100)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "LAST_LOGIN_TIME")
	public String getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	@Column(name = "LOGIN_TIME")
	public String getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	@Column(name = "LOGIN_IP", length = 20)
	public String getLoginIp() {
		return this.loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	@Column(name = "REMARK", length = 100)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Transient
	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

}