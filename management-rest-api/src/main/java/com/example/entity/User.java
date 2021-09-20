package com.example.entity;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Component
public class User {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String avatar;
    private String password;
    
}
