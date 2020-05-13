package com.vivek.spring.restAPI.controllers;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		sessionRepository.deleteByUsername(data.get("username"));
		Session session = new Session(data.get("username"));
	    Random randomGenerator = new Random();
	    
	    
		while(true)
		{
			String generatedString=Integer.toString(1000000+randomGenerator.nextInt()%1000000);
			System.out.println(generatedString);
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
	
	@PostMapping("/api/user")
	public User getUserDetails(@RequestBody Map<String,String> request)
	{
		
		Session session = sessionRepository.findAllBySessionId(request.get("sessionId"));
		//System.out.println(request.toString() + " " + (System.currentTimeMillis()-session.getStartTime().getTime())/(1000*60));
		if(session==null||((((System.currentTimeMillis()-session.getStartTime().getTime())/(1000*60))>30)))
			return null;
		User user =  userRepository.findAllByUsername(session.getUsername());
		//System.out.println(user);
		return user;
	}
	
	@PostMapping("/api/logout")
	public String logoutUser(@RequestBody Map<String,String> request)
	{
		Session session = sessionRepository.findAllBySessionId(request.get("sessionId"));
		if(session==null)
			return "Invalid sessionId";
		else
		{
			sessionRepository.deleteByUsername(session.getUsername());
			return "Logout Successfull";
		}
	}
	
	@PostMapping("/api/updateContact")
	public String updateContact(@RequestBody Map<String,String> request)
	{
		Session session = sessionRepository.findAllBySessionId(request.get("sessionId"));
		if(session==null||((((System.currentTimeMillis()-session.getStartTime().getTime())/(1000*60))>30)))
			return "Invalid sessionId";
		else
		{
			userRepository.updateContact(request.get("contact"),session.getUsername());
			return "Update successfull";
			
		}
	}
}
