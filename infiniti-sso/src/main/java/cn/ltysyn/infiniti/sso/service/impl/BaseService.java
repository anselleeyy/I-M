package cn.ltysyn.infiniti.sso.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import cn.ltysyn.infiniti.sso.dao.IUserDao;

public class BaseService {
	
	@Autowired
	protected IUserDao userDao;

}
