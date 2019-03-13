package cn.ltysyn.inmusic.service;

import cn.ltysyn.inmusic.model.User;

public interface IUserService {
	
	User createUser(String username, String password);

}
