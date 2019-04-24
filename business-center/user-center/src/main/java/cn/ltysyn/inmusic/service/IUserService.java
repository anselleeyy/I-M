package cn.ltysyn.inmusic.service;

import cn.ltysyn.inmusic.dto.PwdDto;
import cn.ltysyn.inmusic.entity.User;

public interface IUserService {
	
	User createUser(User user);
	
	User findByUsername(String username);
	
	User checkLogin(User user);
	
	boolean updatePassword(Long id, PwdDto pwdDto);

}
