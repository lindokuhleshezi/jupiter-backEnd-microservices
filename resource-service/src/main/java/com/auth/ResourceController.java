package com.auth;

import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties.Jwt;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;


@RequestMapping
@RefreshScope
@Slf4j
public class ResourceController {

	@GetMapping("/resource")
	public String resource(@AuthenticationPrincipal Jwt jwt) {
		log.info(String.format("Resource accessed by: %s (with subjectId: %s)" , jwt.getKeyValue(), jwt.getKeyAlias()));
	    return String.format("Resource accessed by: %s (with subjectId: %s)" ,
	            jwt.getKeyValue(),
	            jwt.getKeyAlias());
	}
}
