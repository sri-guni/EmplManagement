package com.sri.empmgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sri.empmgmt.model.User;
import com.sri.empmgmt.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		User user = userRepository.findByUserName(userName);
		if(user == null) {
			throw new UsernameNotFoundException(userName);
		}
		
		return new MyUserPrincipal(user);
	}

}
