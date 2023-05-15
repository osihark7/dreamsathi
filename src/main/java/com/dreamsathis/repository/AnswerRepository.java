package com.dreamsathis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dreamsathis.entity.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Long>{

}
