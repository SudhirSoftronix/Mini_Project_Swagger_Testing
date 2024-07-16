package com.softronix.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Data
@Table(name="PLAN_CATEGEORY")
public class PlanCategeory {

	@Id
	@GeneratedValue
	@Column(name="CATEGEORY_ID")
	private Integer categeoryId;
	
	@Column(name="CATEGEORY_NAME")
	private String categeoryName;
	
	@Column(name="ACTIVE_SW")
	private String activesw;
	
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="UPDATED_BY")
	private String updateBy;
	
	@Column(name="CREATED_DATE", updatable = false)
	@CreationTimestamp
	private LocalDate createdDate;
	
	@Column(name="UPDATED_DATE", insertable = false)
	@UpdateTimestamp
	private LocalDate updatedDate;
}
