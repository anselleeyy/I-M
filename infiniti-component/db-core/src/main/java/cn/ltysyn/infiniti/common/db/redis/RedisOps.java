package cn.ltysyn.infiniti.common.db.redis;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisOps {
	
	@Autowired
	private StringRedisTemplate template;
	
	ValueOperations<String, String> ops;
	
	public void setKey(String key, String value) {
		ops = template.opsForValue();
		ops.set(key, value);
	}
	
	public void setKey(String key, String value, int expire) {
		ops = template.opsForValue();
		ops.set(key, value, expire, TimeUnit.SECONDS);
	}
	
	public String get(String key) {
		ops = template.opsForValue();
		return ops.get(key);
	}

}
