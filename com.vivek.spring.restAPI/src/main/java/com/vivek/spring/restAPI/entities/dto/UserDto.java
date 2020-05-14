package com.vivek.spring.restAPI.entities.dto;

import lombok.Data;

@Data
public class UserDto {
    String username;
    String contact;
    String name;

    public UserDto(String username, String contact, String name) {
        this.username = username;
        this.contact = contact;
        this.name = name;
    }
}
