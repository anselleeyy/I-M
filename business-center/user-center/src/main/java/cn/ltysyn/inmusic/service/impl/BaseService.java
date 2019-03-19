package cn.ltysyn.inmusic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import cn.ltysyn.inmusic.dao.ICollectDao;
import cn.ltysyn.inmusic.dao.IUserDao;
import cn.ltysyn.inmusic.feign.IMusicClient;

public class BaseService {
	
	@Autowired
	protected IUserDao userDao;
	
	@Autowired
	protected ICollectDao collectDao;
	
	@Autowired
	protected IMusicClient musicClient;

}
