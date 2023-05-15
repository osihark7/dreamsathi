package com.dreamsathis.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dreamsathis.bean.ResultDTO;
import com.dreamsathis.entity.BlogDetails;
import com.dreamsathis.utils.Constants;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/home")
public class BlogController extends BaseController {

	@PostMapping("/addBlog")
	public ResponseEntity<?> addBlog(@ModelAttribute BlogDetails blog,
			@RequestParam(value = "file", required = false) MultipartFile file) {
		System.err.println("::::::BlogController.addBlog::::");
		try {
			blogDetailsService.addBlog(blog, file);
			responsePacket = new ResultDTO<>(true, null, Constants.addData);
			return new ResponseEntity<>(responsePacket, HttpStatus.OK);
		} catch (Exception e) {
			responsePacket = new ResultDTO<>(false, null, e.getMessage());
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getBlogList")
	public ResponseEntity<?> getBlogList(@ModelAttribute BlogDetails blog) {
		System.err.println("::::::BlogController.getBlogList::::");
		try {
			List<BlogDetails> blogList = blogDetails.findByStatus(true);
			if (blogList.isEmpty()) {
				responsePacket = new ResultDTO<>(true, null, Constants.recordNotFound);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			} else {
				responsePacket = new ResultDTO<>(true, blogList, Constants.dataGetSucceed);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			}
		} catch (Exception e) {
			responsePacket = new ResultDTO<>(false, null, e.getMessage());
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getBlogListAdmin")
	public ResponseEntity<?> getBlogListAdmin(@ModelAttribute BlogDetails blog) {
		System.err.println("::::::BlogController.getBlogList::::");
		try {
			List<BlogDetails> blogList = blogDetails.findAll();
			if (blogList.isEmpty()) {
				responsePacket = new ResultDTO<>(true, null, Constants.recordNotFound);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			} else {
				responsePacket = new ResultDTO<>(true, blogList, Constants.dataGetSucceed);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			}
		} catch (Exception e) {
			responsePacket = new ResultDTO<>(false, null, e.getMessage());
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/getBlogListById")
	public ResponseEntity<?> getBlogListById(@ModelAttribute BlogDetails blog) {
		System.err.println("::::::BlogController.getBlogListById::::");
		try {
			Optional<BlogDetails> blogList = blogDetails.findById(blog.getId());
			if (blogList.isPresent()) {
				responsePacket = new ResultDTO<>(true, blogList, Constants.dataGetSucceed);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			} else {
				responsePacket = new ResultDTO<>(true, null, Constants.recordNotFound);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			}
		} catch (Exception e) {
			responsePacket = new ResultDTO<>(false, null, e.getMessage());
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}

	
	@PostMapping("/updateBlogListById")
	public ResponseEntity<?> updateBlogListById(@ModelAttribute BlogDetails blog,
			@RequestParam(value = "file", required = false) MultipartFile file) {
		System.err.println("::::::BlogController.updateBlogListById::::");
		try {
			Optional<BlogDetails> blogList = blogDetails.findById(blog.getId());
			if (blogList.isPresent()) {
				blogDetailsService.updateBlogListById(blog, file, blogList);
				responsePacket = new ResultDTO<>(true, blogList, Constants.updateData);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			} else {
				responsePacket = new ResultDTO<>(true, null, Constants.recordNotFound);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			}
		} catch (Exception e) {
			responsePacket = new ResultDTO<>(false, null, e.getMessage());
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/updateBlogStatusListById")
	public ResponseEntity<?> updateBlogStatusListById(@ModelAttribute BlogDetails blog) {
		System.err.println("::::::BlogController.updateBlogStatusListById::::");
		try {
			Optional<BlogDetails> blogList = blogDetails.findById(blog.getId());
			if (blogList.isPresent()) {
				blogDetailsService.updateBlogStatusListById(blog, blogList);
				responsePacket = new ResultDTO<>(true, blogList, Constants.updateData);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			} else {
				responsePacket = new ResultDTO<>(true, null, Constants.recordNotFound);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			}
		} catch (Exception e) {
			responsePacket = new ResultDTO<>(false, null, e.getMessage());
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/removeBlog")
	public Object removeBlog(@ModelAttribute BlogDetails blog) {
		System.err.println("::::::BlogController.removeBlog::::");
		try {
			Optional<BlogDetails> blogList = blogDetails.findById(blog.getId());
			if (blogList.isPresent()) {
				BlogDetails newsUpdateData = blogDetails.findById(blog.getId())
						.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:"));
				blogDetails.delete(newsUpdateData);
				responsePacket = new ResultDTO<>(true, null, Constants.recordDelete);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			} else {
				responsePacket = new ResultDTO<>(false, null, Constants.recordNotFound);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			}

		} catch (Exception e) {
			responsePacket = new ResultDTO<>(false, null, e.getMessage());
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}

	}
}
