package com.vivek.spring.restAPI.repositories;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vivek.spring.restAPI.entities.*;


public interface UserRepository extends JpaRepository<User, String>
{
	public User findAllByUsername(String username);
	@Transactional
	@Modifying
	@Query(value = "UPDATE user u SET u.contact = :contact WHERE u.username = :username", nativeQuery = true)
	public void updateContact(@Param("contact")String contact,@Param("username")String username);
}
