package com.contact.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.contact.dao.UserRepository;
import com.contact.entities.User;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	
	public UserDetailServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//fetching user from database
		
		 User user = userRepository.getUserByUserName(username);
		 
		 if(user==null) {
			 throw new UsernameNotFoundException("Could not found user !!");
		 }
		 
		 CustomUserDetails customUserDetails = new CustomUserDetails(user);
		 
		 
		 
		return customUserDetails;
	}

}
