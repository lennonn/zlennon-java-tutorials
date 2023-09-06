package com.zl.dto.domain;

import static jakarta.persistence.GenerationType.SEQUENCE;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import org.springframework.stereotype.Component;

/**
 * FileSource entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "FILES", schema = "SCOTT")
@Component
public class FileSource implements java.io.Serializable {

	// Fields

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private int fileId;
	private ChildCategory childCategory;
	private String fileName;
	private long fileSize;
	private Date updateDate;
	private String updateUser;
	private Date uploadDate;
	private String uploadUser;
	private String fileUrl;
	private Date downloadDate;
	private Date downloadUser;

	// Constructors

	/** default constructor */
	public FileSource() {
	}

	/** minimal constructor */
	public FileSource(String fileName, long fileSize, String fileUrl) {
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.fileUrl = fileUrl;
	}

	/** full constructor */
	public FileSource(ChildCategory childCategory, String fileName,
			long fileSize, Date updateDate, String updateUser,
			Date uploadDate, String uploadUser, String fileUrl,
			Date downloadDate, Date downloadUser) {
		this.childCategory = childCategory;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
		this.uploadDate = uploadDate;
		this.uploadUser = uploadUser;
		this.fileUrl = fileUrl;
		this.downloadDate = downloadDate;
		this.downloadUser = downloadUser;
	}

	// Property accessors
	@SequenceGenerator(name = "generator",sequenceName="SEQ_FILESOURCE")
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "FILE_ID", unique = true, nullable = false, length = 10)
	public int getFileId() {
		return this.fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "CC_ID")
	public ChildCategory getChildCategory() {
		return this.childCategory;
	}

	public void setChildCategory(ChildCategory childCategory) {
		this.childCategory = childCategory;
	}

	@Column(name = "FILE_NAME", nullable = false, length = 30)
	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name = "FILE_SIZE", nullable = false, length = 10)
	public long getFileSize() {
		return this.fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATE_DATE", length = 7)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "UPDATE_USER", length = 20)
	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPLOAD_DATE", length = 7)
	public Date getUploadDate() {
		return this.uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	@Column(name = "UPLOAD_USER", length = 10)
	public String getUploadUser() {
		return this.uploadUser;
	}

	public void setUploadUser(String uploadUser) {
		this.uploadUser = uploadUser;
	}

	@Column(name = "FILE_URL", nullable = false, length = 500)
	public String getFileUrl() {
		return this.fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DOWNLOAD_DATE", length = 7)
	public Date getDownloadDate() {
		return this.downloadDate;
	}

	public void setDownloadDate(Date downloadDate) {
		this.downloadDate = downloadDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DOWNLOAD_USER", length = 7)
	public Date getDownloadUser() {
		return this.downloadUser;
	}

	public void setDownloadUser(Date downloadUser) {
		this.downloadUser = downloadUser;
	}

}