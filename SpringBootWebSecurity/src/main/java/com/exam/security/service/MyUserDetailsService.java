package com.exam.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exam.dao.IUsersDao;
/*
 *  Step 2: Make a class that extends UserDetailsService so that you can call Jpa
 *  to authenticate user and return UserDetails 
 *  from org.springframework.security.core.userdetails.UserDetails
 */
import com.exam.model.UsersModel;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	IUsersDao userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UsersModel> user = userRepo.findByUserName(username);
		user.orElseThrow(()->new UsernameNotFoundException("Not Found : "+ username));
		return user.map(MyUserDetails::new).get();
	}

}
