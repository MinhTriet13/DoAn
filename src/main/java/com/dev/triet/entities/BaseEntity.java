package com.dev.triet.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass // để spring jpa hiểu các properties của class này là column
public abstract class BaseEntity {
	@Id //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment
	@Column(name = "id")//column name
	private Integer id;
	
	@Column(name = "status", nullable = true)//column name
	private Boolean status = Boolean.TRUE;
	
	@Column(name = "created_by", nullable = true)
	private Integer createdBy;
	
	@Column(name = "updated_by", nullable = true)
	private Integer updatedBy;
	
	@Column(name = "updated_date", nullable = true)
	private Date updatedDate;
	
	@Column(name = "created_date", nullable = true)
	private Date createdDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
	
}
