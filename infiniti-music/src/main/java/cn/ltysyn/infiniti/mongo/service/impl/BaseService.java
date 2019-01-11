package cn.ltysyn.infiniti.mongo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.ltysyn.infiniti.mongo.dao.IAlbumDao;
import cn.ltysyn.infiniti.mongo.dao.IArtistDao;
import cn.ltysyn.infiniti.mongo.dao.ISongDao;

@Component
public class BaseService {
	
	@Autowired
	protected IAlbumDao albumDao;
	
	@Autowired
	protected IArtistDao artistDao;
	
	@Autowired
	protected ISongDao songDao;

}
