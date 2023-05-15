package com.dreamsathis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dreamsathis.entity.BlogDetails;



@Repository
public interface BlogDetailsRepository extends JpaRepository<BlogDetails, Long>{



	List<BlogDetails> findByStatus(boolean b);

}
