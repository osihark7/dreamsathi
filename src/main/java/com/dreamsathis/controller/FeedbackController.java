package com.dreamsathis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dreamsathis.bean.ResultDTO;
import com.dreamsathis.entity.Feedback;
import com.dreamsathis.utils.Constants;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/home")
public class FeedbackController extends BaseController {

	

	@PostMapping("/addComment")
	public ResponseEntity<?> addComment(@ModelAttribute Feedback feedback) {
		System.err.println("::::::FeedbackController.addComment::::");
		try {
			feedbackService.addComment(feedback);
			responsePacket = new ResultDTO<>(true, null, Constants.addData);
			return new ResponseEntity<>(responsePacket, HttpStatus.OK);
		} catch (Exception e) {
			responsePacket = new ResultDTO<>(false, null, e.getMessage());
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/getFeedbackByBlogId")
	public ResponseEntity<?> getFeedbackByBlogId(@ModelAttribute Feedback feedback) {
		System.err.println("::::::FeedbackController.getFeedbackByBlogId::::");
		try {
			Optional<Feedback> feedbacks = feedbackRepository.findByBlogId(feedback.getBlogId());
			if(feedbacks.isPresent()) {
				responsePacket = new ResultDTO<>(true, feedbacks, Constants.dataGetSucceed);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
				
			}else {
				responsePacket = new ResultDTO<>(true, null, Constants.recordNotFound);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			}
			
		} catch (Exception e) {
			responsePacket = new ResultDTO<>(false, null, e.getMessage());
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/getFeedbackList")
	public ResponseEntity<?> getFeedbackList(@ModelAttribute Feedback feedback) {
		System.err.println("::::::FeedbackController.getFeedbackList::::");
		try {
			List<Feedback> feedbacks = feedbackRepository.findAll();
			List<Feedback> feedbackss = feedbackRepository.findByStatus(true);
			if(feedbacks.isEmpty()) {
				responsePacket = new ResultDTO<>(true, null, Constants.recordNotFound);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			}else {
				HashMap<String, Object> data = new HashMap<String, Object>();
				data.put("read", feedbacks);
				data.put("unread", feedbackss.size());
				responsePacket = new ResultDTO<>(true, data, Constants.dataGetSucceed);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			}
			
		} catch (Exception e) {
			responsePacket = new ResultDTO<>(false, null, e.getMessage());
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/updateFeedbackStatus")
	public ResponseEntity<?> updateFeedbackStatus(@ModelAttribute Feedback feedback) {
		System.err.println("::::::FeedbackController.updateFeedbackStatus::::");
		try {
			Optional<Feedback> feedbacks = feedbackRepository.findById(feedback.getId());
			if(feedbacks.isPresent()) {
				feedbackService.updateFeedbackStatus(feedback,feedbacks);
				responsePacket = new ResultDTO<>(true, feedbacks, Constants.updateData);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			}else {
				responsePacket = new ResultDTO<>(true, null, Constants.recordNotFound);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
				
			}
			
		} catch (Exception e) {
			responsePacket = new ResultDTO<>(false, null, e.getMessage());
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PostMapping("/removeFeedback")
	public Object removeFeedback(@ModelAttribute Feedback feedback) {
		System.err.println("::::::BlogController.removeFeedback::::");
		try {
			Optional<Feedback> feedbacks = feedbackRepository.findById(feedback.getId());
			if (feedbacks.isPresent()) {
				Feedback newsUpdateData = feedbackRepository.findById(feedback.getId())
						.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:"));
				feedbackRepository.delete(newsUpdateData);
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
