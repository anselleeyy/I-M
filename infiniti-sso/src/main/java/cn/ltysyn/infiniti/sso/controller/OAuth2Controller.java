package cn.ltysyn.infiniti.sso.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.ltysyn.infiniti.sso.client.RedisClientDetailsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "OAuth2 相关操作")
@RestController
@CrossOrigin
public class OAuth2Controller {
	
	private static final Logger LOG = LoggerFactory.getLogger(OAuth2Controller.class);
	
	private static ApplicationContext applicationContext;

	@ApiOperation(value = "用户名+密码验证")
	@PostMapping(value = "/oauth/user/", produces = "application/json;charset=UTF-8")
	public Object getUserTokenInfo(
			@ApiParam(required = true, name = "username", value = "账号") @RequestParam(value = "username") String username,
			@ApiParam(required = true, name = "password", value = "密码") @RequestParam(value = "password") String password,
			HttpServletRequest request) {
		LOG.info("用户: {}, {} 登录", username, password);
		
		String clientId = request.getHeader("client_id");
		
//		String clientSecret = request.getHeader("client_secret");
		
		RedisClientDetailsService clientDetailsService = applicationContext.getBean(RedisClientDetailsService.class);
		
		ClientDetails clientDetails = clientDetailsService.loadClientByClientId(clientId);
		
		TokenRequest tokenRequest = new TokenRequest(new HashMap<>(1), clientId, clientDetails.getScope(), "customer");
		
		OAuth2Request oAuth2Request = tokenRequest.createOAuth2Request(clientDetails);
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
		
		AuthenticationManager authenticationManager = applicationContext.getBean(AuthenticationManager.class);
		
		Authentication authentication = authenticationManager.authenticate(token);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		OAuth2Authentication oAuth2Authentication = new OAuth2Authentication(oAuth2Request, authentication);
		
		AuthorizationServerTokenServices authorizationServerTokenServices = applicationContext.getBean("defaultAuthorizationServerTokenServices", AuthorizationServerTokenServices.class);
		OAuth2AccessToken oAuth2AccessToken = authorizationServerTokenServices.createAccessToken(oAuth2Authentication);
		
		oAuth2Authentication.setAuthenticated(true);
		
		return oAuth2AccessToken;
	}
	
}
