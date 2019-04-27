package cn.ltysyn.inmusic.service;

import org.springframework.data.domain.Page;
import cn.ltysyn.inmusic.dto.PwdDto;
import cn.ltysyn.inmusic.entity.User;

public interface IUserService {
	
	User createUser(User user);
	
	User findByUsername(String username);
	
	User checkLogin(User user);
	
	boolean updatePassword(Long id, PwdDto pwdDto);
	
	Page<User> findAll(int page, int size);

}
