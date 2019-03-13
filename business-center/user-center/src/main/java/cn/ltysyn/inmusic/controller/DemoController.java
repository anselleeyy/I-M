package cn.ltysyn.inmusic.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	private static final Logger LOG = LoggerFactory.getLogger(DemoController.class);
	
	@Value("${server.port}")
	private String port;
	
	@GetMapping(value = "/hi")
	public String home() {
		return "hi " + port;
	}
	
	@GetMapping(value = "/hello")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String hello() {
		return "hello admin";
	}
	
	public OAuth2Authentication getPrinciple(
			OAuth2Authentication oAuth2Authentication,
			Principal principal, Authentication authentication) {
		
		LOG.info(oAuth2Authentication.getUserAuthentication().getAuthorities().toString());
		LOG.info(oAuth2Authentication.toString());
		LOG.info("principal.toString()"+principal.toString());
		LOG.info("principal.getName()"+principal.getName());
		LOG.info("authentication:"+authentication.getAuthorities().toString());
		
		return oAuth2Authentication;
	}

}
