package com.dreamsathis.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dreamsathis.controller.BaseController;
import com.dreamsathis.entity.BlogDetails;
import com.dreamsathis.utils.Constants;


@Service
public class BlogDetailsService extends BaseController {

	public void addBlog(BlogDetails blog, MultipartFile file) {
		String path = Constants.BASE_DIR + Constants.BLOG_IMAGE;
		String fname = Constants.getRandomPassword() + ".jpg";
		String fileName = Constants.saveMultiPartFile(file, path, fname);
		String url = Constants.BASE_IP +Constants.BASE_DIR + Constants.BLOG_IMAGE;
		 System.err.println("::::::url.addBlog::::"+url);
		blog.setImage(fileName);
		blog.setImgUrl(url);
		blog.setStatus(true);
		blog.setCreatedAt(Constants.getDateAndTime());
		blog.setUpdatedAt(Constants.getDateAndTime());
		blogDetails.save(blog);
	}


	public void updateBlogListById(BlogDetails blog, MultipartFile file, Optional<BlogDetails> blogList) {
		BlogDetails data = blogList.get();
		if (blog!=null) {
			String path = Constants.BASE_DIR + Constants.BLOG_IMAGE;
			String fname = Constants.getRandomPassword() + ".jpg";
			String fileName = Constants.saveMultiPartFile(file, path, fname);
			String url = Constants.BASE_IP +Constants.BASE_DIR + Constants.BLOG_IMAGE;
			 data.setImage(fileName);
			 data.setImgUrl(url);
			 data.setBlogDescription(blog.getBlogDescription());
			 data.setBlogName(blog.getBlogName());
			 data.setUpdatedAt(Constants.getDateAndTime());
			 blogDetails.save(data);
		}
	}


	public void updateBlogStatusListById(BlogDetails blog, Optional<BlogDetails> blogList) {
		BlogDetails data = blogList.get();
		if (data.isStatus() ==true) {
			 data.setStatus(false);
			 data.setUpdatedAt(Constants.getDateAndTime());
			 blogDetails.save(data);
		}else {
			 data.setStatus(true);
			 data.setUpdatedAt(Constants.getDateAndTime());
			 blogDetails.save(data);
		}
	}

	
}
