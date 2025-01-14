package com.LeaveIt.server.repository;

import com.LeaveIt.server.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    @Query("select u.id  from user u where :id=u.id")
    String findByUserId(@Param("id") String id);

    @Query("select u.password  from user u where :id=u.id")
    String findByPassword(@Param("id") String id);


    @Query("select u.feedUID  from Review u where :id=u.feedUID")
    String findByLikeId(@Param("id") String id);

}
