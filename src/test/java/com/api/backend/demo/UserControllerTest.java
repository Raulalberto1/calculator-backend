package com.api.backend.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import com.api.backend.demo.controller.UserController;
import com.api.backend.demo.model.UserDataResponse;

@SpringBootTest
public class UserControllerTest {

	@Autowired
	private UserController userController;
	
	@Test
    @DisplayName("Value of returns valid user login")
    void login() {
		Map<String, String> payload = Map.of(
	        "username", "user1",
	        "password", "password1"
        );
		ResponseEntity<UserDataResponse>response = userController.login(payload);
		assertEquals(response.getStatusCode(),HttpStatusCode.valueOf(200));
	}
	
	@Test
    @DisplayName("Value of returns valid user login")
    void userNotFound() {
		Map<String, String> payload = Map.of(
	        "username", "user",
	        "password", "password"
        );
		ResponseEntity<UserDataResponse>response = userController.login(payload);
		assertEquals(response.getStatusCode(),HttpStatusCode.valueOf(404));
	}
	
	@Test
    @DisplayName("Value of returns valid user login")
    void userUnauthorized() {
		Map<String, String> payload = Map.of(
	        "username", "user1",
	        "password", "password"
        );
		ResponseEntity<UserDataResponse>response = userController.login(payload);
		assertEquals(response.getStatusCode(),HttpStatusCode.valueOf(401));
	}
	
	@Test
    @DisplayName("Value of returns valid user login")
    void userInactive() {
		Map<String, String> payload = Map.of(
	        "username", "user3",
	        "password", "password3"
        );
		ResponseEntity<UserDataResponse>response = userController.login(payload);
		assertEquals(response.getStatusCode(),HttpStatusCode.valueOf(403));
	}
}
