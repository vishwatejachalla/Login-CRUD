package com.cognizant.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cognizant.login.model.User;



@Repository
public interface UserRepository extends JpaRepository<User, Integer>  {
	
	@Query(value="select * from user where us_id=:id",nativeQuery=true)
	public User findId(@Param(value = "id") int id); 

	@Query(value="select * from user where us_email=:email AND us_password=:password",nativeQuery=true)
	public User findByEmail(@Param(value = "email") String email,@Param(value="password") String password); 
}