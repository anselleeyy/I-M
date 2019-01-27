package cn.ltysyn.infiniti.sso.service;

import cn.ltysyn.infiniti.sso.entity.User;

public interface IUserService {
	
	/**
	 * 通过用户名获取用户
	 * @param username
	 * @return
	 */
	User findByUsername(String username);

}
