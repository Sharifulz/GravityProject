package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.jwtutil.JwtUtil;
import com.exam.payload.AuthenticationRequest;
import com.exam.payload.AuthenticationResponse;
import com.exam.security.service.MyUserDetailsService;

@RestController
public class HomeController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired 
	private MyUserDetailsService userDetailsService;
	
	@Autowired 
	private JwtUtil jwtUtil;
	
	@GetMapping("/hello")
	public String login() {
		System.out.println("Hellow world page");
		return "hellow world";
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authReqViewModel) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authReqViewModel.getUserName(), authReqViewModel.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password " + e);
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authReqViewModel.getUserName());
		final String jwt = jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
	
	
	
}
