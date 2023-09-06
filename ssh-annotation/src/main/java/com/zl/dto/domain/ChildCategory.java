package com.zl.dto.domain;

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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import org.springframework.stereotype.Component;

/**
 * ChildCategory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CHILD_CATEGORIES", schema = "SCOTT")
@Component
public class ChildCategory implements java.io.Serializable {

	// Fields

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private int ccId;
	private Category category;
	private String ccName;
	private Date updateDate;
	private String ccDesc;
	private Set<FileSource> fileSources = new HashSet<FileSource>(0);

	// Constructors

	/** default constructor */
	public ChildCategory() {
	}

	/** minimal constructor */
	public ChildCategory(Category category, String ccDesc) {
		this.category = category;
		this.ccDesc = ccDesc;
	}

	/** full constructor */
	public ChildCategory(Category category, String ccName, Date updateDate,
			String ccDesc, Set<FileSource> fileSources) {
		this.category = category;
		this.ccName = ccName;
		this.updateDate = updateDate;
		this.ccDesc = ccDesc;
		this.fileSources = fileSources;
	}

	// Property accessors
	@SequenceGenerator(name = "generator",sequenceName="SEQ_CHILDCATEGORY")
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "CC_ID", unique = true, nullable = false, length = 10)
	public int getCcId() {
		return this.ccId;
	}

	public void setCcId(int ccId) {
		this.ccId = ccId;
	}

	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "ID", nullable = false)
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "CC_NAME", length = 50)
	public String getCcName() {
		return this.ccName;
	}

	public void setCcName(String ccName) {
		this.ccName = ccName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATE_DATE", length = 7)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "CC_DESC", nullable = false, length = 100)
	public String getCcDesc() {
		return this.ccDesc;
	}

	public void setCcDesc(String ccDesc) {
		this.ccDesc = ccDesc;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "childCategory")
	public Set<FileSource> getFileSources() {
		return this.fileSources;
	}

	public void setFileSources(Set<FileSource> fileSources) {
		this.fileSources = fileSources;
	}

}