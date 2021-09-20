package com.example.service;

import java.util.ArrayList;
import java.util.List;

import com.example.entity.User;

import org.springframework.stereotype.Component;

@Component
public class UserServiceImplement implements UserService {
    private static ArrayList<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Nguyen thi mong mo", "mongmo@gmail.com", "0981237654", "avatar.jpg", "123"));
        users.add(new User(2, "Nguyen van lang lo", "langlo@gmail.com", "0978122334", "avatar2.jpg", "234"));
        users.add(new User(3, "Do van that tha", "thatha@gamil.com", "0987678543", "avatar3.jpg", "345"));
    }

    @Override
    public List<User> getListUser() {
        // TODO Auto-generated method stub
        return users;
    }
}
