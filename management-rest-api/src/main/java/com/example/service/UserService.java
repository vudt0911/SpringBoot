package com.example.service;

import java.util.List;

import com.example.entity.User;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public List<User> getListUser();
}
