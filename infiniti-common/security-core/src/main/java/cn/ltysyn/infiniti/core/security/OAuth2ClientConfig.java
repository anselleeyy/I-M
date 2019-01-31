package cn.ltysyn.infiniti.core.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import cn.ltysyn.infiniti.common.props.PermitUrlProperties;
import cn.ltysyn.infiniti.core.security.authorize.AuthorizeConfigManager;

@Component
@Configuration
@EnableResourceServer
@EnableConfigurationProperties(PermitUrlProperties.class)
public class OAuth2ClientConfig extends ResourceServerConfigurerAdapter {
	
	@Autowired
	private AuthenticationEntryPoint authenticationEntryPoint;
	
	@Autowired
	private AuthenticationFailureHandler authenticationFailureHandler;
	
	@Autowired(required = false)
	private TokenStore redisTokenStore;

	@Autowired(required = false)
	private JwtTokenStore jwtTokenStore;
	
	@Autowired(required = false)
	private JwtAccessTokenConverter jwtAccessTokenConverter;
	
	@Autowired
	private AuthorizeConfigManager authorizeConfigManager;

	@Autowired
	private OAuth2WebSecurityExpressionHandler expressionHandler;
	
	@Autowired
	private OAuth2AccessDeniedHandler oAuth2AccessDeniedHandler;
	
	@Autowired
	private PermitUrlProperties permitUrlProperties;
	
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(permitUrlProperties.getIgnored());
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		// TODO Auto-generated method stub
		if (jwtTokenStore != null) {
			resources.tokenStore(jwtTokenStore);
		} else if (redisTokenStore != null) {
			resources.tokenStore(redisTokenStore);
		}
		resources.stateless(true);

		resources.authenticationEntryPoint(authenticationEntryPoint);

		resources.expressionHandler(expressionHandler);
		resources.accessDeniedHandler(oAuth2AccessDeniedHandler);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable();
		http.headers().frameOptions().disable();

		authorizeConfigManager.config(http.authorizeRequests());
	}

}
