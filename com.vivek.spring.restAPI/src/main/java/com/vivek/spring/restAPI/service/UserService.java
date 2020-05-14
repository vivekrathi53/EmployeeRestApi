package com.vivek.spring.restAPI.service;

import com.vivek.spring.restAPI.Entities.User;

public interface UserService {
    public void registerUser(User user);
    public boolean authenticate(String username,String password);
    public User getUserDetails(String username);
    public boolean updateContact(String username,String newContact);

}
