package cn.ltysyn.inmusic.service.impl;

import java.util.concurrent.TimeUnit;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import cn.ltysyn.inmusic.dto.PwdDto;
import cn.ltysyn.inmusic.entity.User;
import cn.ltysyn.inmusic.service.IUserService;
import cn.ltysyn.inmusic.utils.NginxUtil;
import cn.ltysyn.inmusic.utils.TokenUtil;

@Service(value = "userService")
public class UserServiceImpl extends BaseService implements IUserService {
	
	private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private StringRedisTemplate redisTemplate;

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		User result = null;
		if (user != null) {
			// 加密密码
			String hash = encoder.encode(user.getPassword());
			user.setPassword(hash);
			user.setAvatar(NginxUtil.COMMON_AVATAR);
			try {
				result = userDao.save(user);
				return result;
			} catch (Exception e) {
				// TODO: handle exception
				LOG.error("save user: {} failed", user);
				return result;
			}
		}
		return result;
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
		// 用户存在
		if (null != realUser) {
			// 密码正确
			if (encoder.matches(user.getPassword(), realUser.getPassword())) {
				String token = TokenUtil.generateToken();
				LOG.info("token: {}", token);
				realUser.setToken(token);
				redisTemplate.boundValueOps(token).set(JSON.toJSONString(realUser), TokenUtil.TOKEN_EXPIRE_HOUR, TimeUnit.HOURS);
				return realUser;
			}
		}
		return null;
	}

	@Override
	@Transactional
	public boolean updatePassword(Long id, PwdDto pwdDto) {
		// TODO Auto-generated method stub
		String oldPassword = pwdDto.getOldPassword();
		String newPassword = pwdDto.getNewPassword();
		if (oldPassword == null || newPassword == null) {
			return false;
		}
		User user = userDao.findById(id).get();
		// 校验旧密码是否正确
		if (encoder.matches(oldPassword, user.getPassword())) {
			// 开始更新密码
			userDao.updatePassword(encoder.encode(newPassword));
			return true;
		}
		return false;
	}

	@Override
	public Page<User> findAll(int page, int size) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(page-1, size);
		Page<User> users = userDao.findAll(pageable);
		return users;
	}

}
