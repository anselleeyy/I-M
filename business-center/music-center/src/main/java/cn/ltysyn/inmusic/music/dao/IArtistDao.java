package cn.ltysyn.inmusic.music.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.ltysyn.inmusic.music.entity.Artist;

public interface IArtistDao extends JpaRepository<Artist, Integer> {
	
	Artist findByArtistId(Integer artistId);

}
