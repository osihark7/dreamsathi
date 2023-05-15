package com.dreamsathis.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dreamsathis.entity.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback,Long>{

	Optional<Feedback> findByBlogId(Long blogId);

	List<Feedback> findByStatus(boolean b);
}
