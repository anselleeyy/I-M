package cn.ltysyn.inmusic.service;

import java.util.List;

import cn.ltysyn.inmusic.entity.UserCollection;

public interface ICollectService {
	
	public List<Object> getAllCollectsByUsername(Long userId);
	
	public boolean addCollect(UserCollection collection);
	
	public boolean deleteCollect(UserCollection collection);

}
