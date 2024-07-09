package com.api.backend.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.backend.demo.model.User;
import com.api.backend.demo.model.UserDataResponse;
import com.api.backend.demo.service.OperationService;
import com.api.backend.demo.service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<UserDataResponse> login(@RequestBody Map<String, String> payload){
		return userService.login(payload.get("username"), payload.get("password"));
	}
}
