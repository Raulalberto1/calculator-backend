package com.api.backend.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.backend.demo.model.User;
import com.api.backend.demo.model.UserDataResponse;
import com.api.backend.demo.repository.UserRepository;
import com.api.backend.demo.utils.Constants;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	

	
	/*public ResponseEntity<User> login(String username, String password) {
		User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
		if(!user.getPassword().equals(password)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
		if(user.getStatus().equalsIgnoreCase(Constants.STATUS_INACTIVE)) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
		}
		return ResponseEntity.ok(user);
	}*/
	
	public ResponseEntity<UserDataResponse> login(String username, String password) {
		Optional<User> user = userRepository.findByUsername(username);
		UserDataResponse userDataResponse=new UserDataResponse();
		if(user.isEmpty()) {
			userDataResponse.setMessage("User not found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userDataResponse);
		}
		if(!user.get().getPassword().equals(password)) {
			userDataResponse.setMessage("Invalid password");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(userDataResponse);
		}
		if(user.get().getStatus().equalsIgnoreCase(Constants.STATUS_INACTIVE)) {
			userDataResponse.setMessage("User not available");
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(userDataResponse);
		}
		userDataResponse.setUser(user.get());
		return ResponseEntity.ok(userDataResponse);
	}
}
