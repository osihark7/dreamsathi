package com.dreamsathis.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long answerId;
	private String answer;
	private boolean status;
	private String createdAt;
	private String updatedAt;
	public Long getAnswerId() {
		return answerId;
	}
	public String getAnswer() {
		return answer;
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
	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
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
	
	
