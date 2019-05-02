package cn.ltysyn.inmusic.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.ltysyn.inmusic.entity.UserCollection;

public interface ICollectDao extends JpaRepository<UserCollection, Long> {
	
	List<UserCollection> findAllByUserId(Long userId);
	
	@Modifying
	@Query(value = "delete from t_user_collection where userId = ?1 and songId = ?2")
	void deleteCollect(long userId, long songId);

}
