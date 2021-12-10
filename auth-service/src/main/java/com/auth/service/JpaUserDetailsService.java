package com.auth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth.feignClients.ApplicationUserFeignClient;
import com.auth.objects.ApplicationUser;
import com.auth.objects.SecurityUser;

@Service
public class JpaUserDetailsService implements UserDetailsService {

	@Autowired
	private ApplicationUserFeignClient applicationUserFeignClient;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {	
		Optional<ApplicationUser> u = applicationUserFeignClient.findUserByUserName(username);
		if(!u.isPresent()) {
			throw new UsernameNotFoundException("User not found with the given username");
		}
        return new SecurityUser(u.get());
	}

}
