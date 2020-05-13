package com.vivek.spring.restAPI.controllers;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.spring.restAPI.Entities.Session;
import com.vivek.spring.restAPI.Entities.User;
import com.vivek.spring.restAPI.Repositories.SessionRepository;
import com.vivek.spring.restAPI.Repositories.UserRepository;

@RestController
public class restAPIController {
	
	private UserRepository userRepository;
	private SessionRepository sessionRepository;
	
	public restAPIController(UserRepository userRepository,SessionRepository sessionRepository)
	{
		this.userRepository=userRepository;
		this.sessionRepository=sessionRepository;
	}

	
	@PostMapping("/api/signup")
	public User signUpUser(@RequestBody User user)
	{
		//System.out.println(user.toString());
		return userRepository.save(user);
	}
	
	@PostMapping("/api/login")
	public String loginUser(@RequestBody Map<String,String> data)
	{
		User user = userRepository.findAllByUsername(data.get("username"));
		if(user==null||(!user.getPassword().equals(data.get("password"))))
			return null;
		sessionRepository.deleteAllByUsername(data.get("username"));
		Session session = new Session(data.get("username"));
		byte[] array = new byte[7]; // length is bounded by 7
	    Random randomGenerator = new Random();
	    
	    
		while(true)
		{
			randomGenerator.nextBytes(array);
			String generatedString = new String(array, Charset.forName("UTF-8"));
			Session existingSession =sessionRepository.findAllBySessionId(generatedString);
			if(existingSession==null)
			{
				session.setSessionId(generatedString);
				sessionRepository.save(session);
				break;
			}
		}
		
		return session.getSessionId();
	}
}
