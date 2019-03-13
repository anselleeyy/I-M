package cn.ltysyn.inmusic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import cn.ltysyn.inmusic.service.UserServiceDetail;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	
	
	@Autowired
	private RedisConnectionFactory connectionFactory;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserServiceDetail userServiceDetail;
	
	private static final String SECRET_KEY = "{bcrypt}" + new BCryptPasswordEncoder().encode("123456");
	
	@Bean
    public RedisTokenStore tokenStore() {
        return new RedisTokenStore(connectionFactory);
    }
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		// TODO Auto-generated method stub
		clients.inMemory()
			.withClient("browser")
			.authorizedGrantTypes("refresh_token", "password")
			.scopes("ui")
			.and()
			.withClient("music-center")
			.secret(SECRET_KEY)
			.authorizedGrantTypes("client_credentials", "refresh_token", "password")
			.scopes("server")
			.and()
			.withClient("user-center")
			.secret(SECRET_KEY)
			.authorizedGrantTypes("client_credentials", "refresh_token", "password")
			.scopes("server");
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		// TODO Auto-generated method stub
		endpoints
			.tokenStore(tokenStore())
			.authenticationManager(authenticationManager)
			.userDetailsService(userServiceDetail);
	}
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		// TODO Auto-generated method stub
		security
			.tokenKeyAccess("permitAll()")
			.checkTokenAccess("isAuthenticated()");
	}

}
