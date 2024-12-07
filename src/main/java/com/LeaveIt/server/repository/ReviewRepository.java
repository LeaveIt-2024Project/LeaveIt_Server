package com.LeaveIt.server.repository;

import com.LeaveIt.server.repository.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReviewRepository  extends JpaRepository<Review , String> {

}
