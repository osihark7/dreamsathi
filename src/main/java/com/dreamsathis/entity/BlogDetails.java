package com.dreamsathis.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BlogDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private long id;
	
	private String blogName;
	
	private String blogDescription;
	
	private String imgUrl;
	
	private String image;
	
	private boolean status;
	
	private String createdAt;
	
	private String updatedAt;

	public long getId() {
		return id;
	}

	public String getBlogName() {
		return blogName;
	}

	public String getBlogDescription() {
		return blogDescription;
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

	public void setId(long id) {
		this.id = id;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public void setBlogDescription(String blogDescription) {
		this.blogDescription = blogDescription;
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

}
