package cn.ltysyn.infiniti.gateway.filter;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class AccessFilter implements GlobalFilter, Ordered {
	
	// url 匹配器
	private AntPathMatcher pathMatcher = new AntPathMatcher();
	
	@Resource
	private RedisTemplate<String, Object> redisTemplate;
	

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return -500;
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		// TODO Auto-generated method stub
		String accessToken = extractToken(exchange.getRequest());
		
		if (pathMatcher.match("/**/v2/api-docs/**", exchange.getRequest().getPath().value())) {
			return chain.filter(exchange);
		}
		
		if (!pathMatcher.match("/api-auth/**", exchange.getRequest().getPath().value())) {
			if (accessToken == null) {
				exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
				return exchange.getResponse().setComplete();
			} else {
				try {
					// redis 认证
					String params = (String) redisTemplate.opsForValue().get("token:" + accessToken);
					if (params == null || "".equals(params)) {
						exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
						return exchange.getResponse().setComplete();
					}
				} catch (Exception e) {
					// TODO: handle exception
					exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
					return exchange.getResponse().setComplete();
				}
			}
		}
		
		return chain.filter(exchange);
	}
	
	private String extractToken(ServerHttpRequest request) {
		List<String> strings = request.getHeaders().get("Authorization");
		String authToken = null;
		if (strings != null) {
			authToken = strings.get(0).substring("Bearer".length()).trim();
		}
		
		if (StringUtils.isBlank(authToken)) {
			strings = request.getQueryParams().get("access_token");
			if (strings != null) {
				authToken = strings.get(0);
			}
		}
		
		return authToken;
	}

}
