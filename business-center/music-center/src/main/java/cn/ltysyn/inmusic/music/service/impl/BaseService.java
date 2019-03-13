package cn.ltysyn.inmusic.music.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.ltysyn.inmusic.music.dao.IAlbumDao;
import cn.ltysyn.inmusic.music.dao.IArtistDao;
import cn.ltysyn.inmusic.music.dao.ISongDao;

@Component
public class BaseService {
	
	@Autowired
	protected IArtistDao artistDao;
	
	@Autowired
	protected IAlbumDao albumDao;
	
	@Autowired
	protected ISongDao songDao;

}
