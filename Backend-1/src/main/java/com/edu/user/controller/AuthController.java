package com.edu.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edu.common.EmailVerificationService;
import com.edu.common.JwtUtils;
import com.edu.user.dto.LoginRequest;
import com.edu.user.dto.SignUpRequest;
import com.edu.user.dto.UserResponse;
import com.edu.user.entitiy.User;
import com.edu.user.service.UserService;

@RestController
public class AuthController {
	@Autowired
	private UserService userService;
	@Autowired
	private EmailVerificationService emailVerificationService;
	@Autowired
	private JwtUtils jwtUtils;

	@PostMapping("/signup")
	public ResponseEntity<UserResponse> registerUser(@RequestBody SignUpRequest signUpRequest) {
		UserResponse response = userService.registerUser(signUpRequest);
        User user = userService.findByUsername(signUpRequest.getUsername());
        String token = emailVerificationService.generateVerificationToken(user);
        emailVerificationService.sendVerificationEmail(user, token);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/login")
	public ResponseEntity<UserResponse> loginUser(@RequestBody LoginRequest loginRequest) {
		UserResponse response = userService.loginUser(loginRequest);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/verify")
	public ResponseEntity<String> verifyEmail(@RequestParam("token") String token) {
		boolean verified = emailVerificationService.verifyEmail(token);
		if (verified) {
			return ResponseEntity.ok("Email verified successfully.");
		} else {
			return ResponseEntity.status(400).body("Invalid or expired token.");
		}
	}
}
