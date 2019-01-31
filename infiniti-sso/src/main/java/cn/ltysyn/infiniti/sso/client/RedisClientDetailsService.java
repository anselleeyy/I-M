package cn.ltysyn.infiniti.sso.client;

import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.oauth2.common.exceptions.InvalidClientException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSONObject;

public class RedisClientDetailsService extends JdbcClientDetailsService {

	public RedisClientDetailsService(DataSource dataSource) {
		super(dataSource);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 缓存 client 的 redis key, 这里是 hash 结构存储
	 */
	private static final String CACHE_CLIENT_KEY = "oauth_client_details";

	private static final Logger LOG = LoggerFactory.getLogger(RedisClientDetailsService.class);

	private RedisTemplate<String, Object> redisTemplate;

	public RedisTemplate<String, Object> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Override
	public ClientDetails loadClientByClientId(String clientId) throws InvalidClientException {
		// TODO Auto-generated method stub
		ClientDetails clientDetails = null;

		String value = (String) redisTemplate.boundHashOps(CACHE_CLIENT_KEY).get(clientId);
		if (StringUtils.isBlank(value)) {
			clientDetails = cacheAndGetClient(clientId);
		} else {
			clientDetails = JSONObject.parseObject(value, BaseClientDetails.class);
		}
		return clientDetails;
	}

	/**
	 * 缓存 client 并返回
	 * 
	 * @param clientId
	 * @return
	 */
	private ClientDetails cacheAndGetClient(String clientId) {
		// TODO Auto-generated method stub
		ClientDetails clientDetails = null;
		try {
			clientDetails = super.loadClientByClientId(clientId);
			if (clientDetails != null) {
				// 写入 redis 缓存
				redisTemplate.boundHashOps(CACHE_CLIENT_KEY).put(clientId, JSONObject.toJSONString(clientDetails));
				LOG.info("缓存 clientId: {}, {}", clientId, clientDetails);
			}
		} catch (NoSuchClientException e) {
			// TODO: handle exception
			LOG.error("缓存 clientId: {}, {}", clientId, clientDetails);
		} catch (InvalidClientException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return clientDetails;
	}

	@Override
	public void updateClientDetails(ClientDetails clientDetails) throws NoSuchClientException {
		// TODO Auto-generated method stub
		super.updateClientDetails(clientDetails);
		cacheAndGetClient(clientDetails.getClientId());
	}

	@Override
	public void updateClientSecret(String clientId, String secret) throws NoSuchClientException {
		// TODO Auto-generated method stub
		super.updateClientSecret(clientId, secret);
		cacheAndGetClient(clientId);
	}

	@Override
	public void removeClientDetails(String clientId) throws NoSuchClientException {
		// TODO Auto-generated method stub
		super.removeClientDetails(clientId);
		removeRedisCache(clientId);
		
	}
	
	private void removeRedisCache(String clientId) {
		redisTemplate.boundHashOps(CACHE_CLIENT_KEY).delete(clientId);
	}
	
	public void loadAllClientToCache() {
		// TODO Auto-generated method stub
		if (redisTemplate.hasKey(CACHE_CLIENT_KEY)) {
			return;
		}
		LOG.info("将 oauth_client_details 全表刷入 redis");
		
		List<ClientDetails> list = super.listClientDetails();
		if (CollectionUtils.isEmpty(list)) {
			LOG.error("oauth_client_details 表数据为空，请检查");
			return;
		}
		list.parallelStream().forEach(client -> {
			redisTemplate.boundHashOps(CACHE_CLIENT_KEY).put(client.getClientId(), JSONObject.toJSONString(client));
		});

	}

}
