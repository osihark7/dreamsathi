package com.dreamsathis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dreamsathis.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{

}
