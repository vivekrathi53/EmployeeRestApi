package com.vivek.spring.restAPI.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vivek.spring.restAPI.Entities.*;


public interface UserRepository extends JpaRepository<User, String>
{
	public User findAllByUsername(String username);
}
