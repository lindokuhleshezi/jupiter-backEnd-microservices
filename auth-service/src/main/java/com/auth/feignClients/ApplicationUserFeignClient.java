package com.auth.feignClients;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.auth.objects.ApplicationUser;

@FeignClient("${client.name.user-service}")
public interface ApplicationUserFeignClient {

	@GetMapping(path = "/users/findByUserName/{username}")
	Optional<ApplicationUser> findUserByUserName(@PathVariable String username);
}
