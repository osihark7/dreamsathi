package com.dreamsathis.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Feedback {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Id
	private Long id;
	private String name;
	private String email;
	private String website;
	private String comment;
	private Long blogId;
	private String imgUrl;
	
	private String image;
	
	private boolean status;
	
	private String createdAt;
	
	private String updatedAt;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getWebsite() {
		return website;
	}

	public String getComment() {
		return comment;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getImage() {
		return image;
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

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public void setImage(String image) {
		this.image = image;
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

	public Long getBlogId() {
		return blogId;
	}

	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}

}
