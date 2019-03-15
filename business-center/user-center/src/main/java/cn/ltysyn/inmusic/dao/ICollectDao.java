package cn.ltysyn.inmusic.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.ltysyn.inmusic.entity.UserCollection;

public interface ICollectDao extends JpaRepository<UserCollection, Long> {

}
