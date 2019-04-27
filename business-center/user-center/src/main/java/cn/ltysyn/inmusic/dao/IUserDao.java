package cn.ltysyn.inmusic.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.ltysyn.inmusic.entity.User;


public interface IUserDao extends JpaRepository<User, Long> {
	
	User findByUsername(String username);
	
//	Optional<User> findById(Long id);
	
	@Modifying
	@Query(value = "update t_user set password = ?1")
	void updatePassword(String password);
	
	Page<User> findAll(Pageable pageable);

}
