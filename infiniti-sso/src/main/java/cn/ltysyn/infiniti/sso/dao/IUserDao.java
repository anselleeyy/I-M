package cn.ltysyn.infiniti.sso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.ltysyn.infiniti.sso.entity.User;

public interface IUserDao extends JpaRepository<User, String> {
	
	User findByUsername(String username);

}
