package cn.ltysyn.inmusic.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.ltysyn.inmusic.entity.UserCollection;

public interface ICollectDao extends JpaRepository<UserCollection, Long> {
	
	List<UserCollection> findAllByUserId(Long userId);

}
