package com.dreamsathis.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private long id;
	
	private String question;
	
	private boolean status;
	
	private String createdAt;
	
	private String updatedAt;
	
	public long getId() {
		return id;
	}
	public String getQuestion() {
		return question;
	}
	public boolean isStatus() {
		return status;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
}
