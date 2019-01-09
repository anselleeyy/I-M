package cn.ltysyn.infiniti.mongo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import cn.ltysyn.infiniti.mongo.dao.IAlbumDao;
import cn.ltysyn.infiniti.mongo.dao.IArtistDao;
import cn.ltysyn.infiniti.mongo.dao.ISongDao;

public class BaseService {
	
	@Autowired
	protected IAlbumDao albumDao;
	
	@Autowired
	protected IArtistDao artistDao;
	
	@Autowired
	protected ISongDao songDao;

}
