package cn.ltysyn.inmusic.service.impl;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import cn.ltysyn.inmusic.dao.IUserDao;
import cn.ltysyn.inmusic.entity.User;
import cn.ltysyn.inmusic.service.IUserService;
import cn.ltysyn.inmusic.utils.TokenUtil;

@Service(value = "userService")
public class UserServiceImpl implements IUserService {
	
	private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	@Autowired
	private IUserDao userDao;

	@Override
	public boolean createUser(User user) {
		// TODO Auto-generated method stub
		if (user != null) {
			// 加密密码
			String hash = encoder.encode(user.getPassword());
			user.setPassword(hash);
			try {
				userDao.save(user);
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				LOG.error("save user: {} failed", user);
			}
		}
		return false;
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.findByUsername(username);
	}

	@Override
	public User checkLogin(User user) {
		// TODO Auto-generated method stub
		String username = user.getUsername();
		User realUser = userDao.findByUsername(username);
		LOG.debug("数据库信息: {}", realUser);
		if (encoder.matches(user.getPassword(), realUser.getPassword())) {
			String token = TokenUtil.generateToken();
			LOG.info("token: {}", token);
			realUser.setToken(token);
			redisTemplate.boundValueOps(token).set(JSON.toJSONString(realUser), TokenUtil.TOKEN_EXPIRE_HOUR, TimeUnit.HOURS);
			return realUser;
		}
		return null;
	}

}
