package com.zl.dto.domain;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;

import static jakarta.persistence.GenerationType.SEQUENCE;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


/**
 * Category entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ROOT_CATEGORY", schema = "SCOTT")
@Component
public class Category implements java.io.Serializable {

	// Fields

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String CName;
	private Date updateDate;
	private String CDesc;
	private Set<ChildCategory> childCategories = new HashSet<ChildCategory>(0);

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** full constructor */
	public Category(String CName, Date updateDate, String CDesc,
			Set<ChildCategory> childCategories) {
		this.CName = CName;
		this.updateDate = updateDate;
		this.CDesc = CDesc;
		this.childCategories = childCategories;
	}

	// Property accessors
	@SequenceGenerator(name = "generator" ,sequenceName="SEQ_CATEGORY")
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "ID", unique = true, nullable = false, length = 10)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "C_NAME", length = 20)
	public String getCName() {
		return this.CName;
	}

	public void setCName(String CName) {
		this.CName = CName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATE_DATE", length = 7)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "C_DESC", length = 100)
	public String getCDesc() {
		return this.CDesc;
	}

	public void setCDesc(String CDesc) {
		this.CDesc = CDesc;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "category")
	public Set<ChildCategory> getChildCategories() {
		return this.childCategories;
	}

	public void setChildCategories(Set<ChildCategory> childCategories) {
		this.childCategories = childCategories;
	}

}