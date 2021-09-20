package com.example.controller.controller;

import java.util.List;

import com.example.entity.User;
import com.example.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 */
@RequestMapping("/users")
@RestController
public class UserController {
// @RequestMapping(value = "/users", method = RequestMethod.GET) // cach doi voi version cu
@Autowired
private UserService userService;

@GetMapping("")
public ResponseEntity<?> getListUser() {
    List<User> users = userService.getListUser();
    return ResponseEntity.ok(users);
}

@PostMapping("")
public ResponseEntity<?> createUser() {
    return null;
}

@PutMapping("/{id}")
public ResponseEntity<?> updatetUser() {
    return null;
}

@DeleteMapping("/{id}")
public ResponseEntity<?> deleteUser() {
    return null;
}
    
}