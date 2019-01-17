package cn.ltysyn.infiniti.music.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.ltysyn.infiniti.music.entity.Artist;

public interface IArtistDao extends JpaRepository<Artist, Integer> {

}
