package cn.ltysyn.infiniti.sso.service.impl;

import org.springframework.stereotype.Service;

import cn.ltysyn.infiniti.sso.entity.User;
import cn.ltysyn.infiniti.sso.service.IUserService;

@Service(value = "userService")
public class UserServiceImpl extends BaseService implements IUserService {

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.findByUsername(username);
	}

}
