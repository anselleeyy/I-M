package cn.ltysyn.inmusic.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.ltysyn.inmusic.model.User;


public interface IUserDao extends JpaRepository<User, Long> {
	
	User findByUsername(String username);

}
