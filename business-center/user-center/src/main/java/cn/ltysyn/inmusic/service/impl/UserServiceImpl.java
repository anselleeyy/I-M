package cn.ltysyn.inmusic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cn.ltysyn.inmusic.dao.IUserDao;
import cn.ltysyn.inmusic.entity.User;
import cn.ltysyn.inmusic.service.IUserService;

@Service(value = "userService")
public class UserServiceImpl implements IUserService {
	
	private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Autowired
	private IUserDao userDao;

	@Override
	public User createUser(String username, String password) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUsername(username);
		String hash = encoder.encode(password);
		user.setPassword(hash);
		User u = userDao.save(user);
		return u;
	}

}
