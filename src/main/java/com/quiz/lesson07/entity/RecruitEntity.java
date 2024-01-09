package com.quiz.lesson07.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor	
@Builder(toBuilder = true)
@Getter
@Table(name = "recruit")
@Entity
public class RecruitEntity {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "companyId")
	private int companyId;
	
	private String position;
	private String responsibilities;
	private String qualification;
	private String type;
	private String region;
	private int salary;
	private Date deadline;
	
	@Column(name ="createdAt", updatable = false)
	private Date createdAt;
	
	@Column(name ="updatedAt")
	private Date updatedAt;
	
}
