package com.dreamsathis.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dreamsathis.controller.BaseController;
import com.dreamsathis.entity.Feedback;
import com.dreamsathis.utils.Constants;

@Service
public class FeedbackService extends BaseController{

	public void addComment(Feedback feedback) {
		feedback.setStatus(true);
		feedback.setCreatedAt(Constants.getDateAndTime());
		feedback.setUpdatedAt(Constants.getDateAndTime());
		feedbackRepository.save(feedback);
	}

	public void updateFeedbackStatus(Feedback feedback, Optional<Feedback> feedbacks) {
		if(feedbacks.isPresent()) {
			Feedback data = feedbacks.get();
			data.setStatus(false);
			data.setUpdatedAt(Constants.getDateAndTime());
			feedbackRepository.save(data);
		}
	}

}
