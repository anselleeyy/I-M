package cn.ltysyn.infiniti.music.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.ltysyn.infiniti.music.entity.Song;

public interface ISongDao extends JpaRepository<Song, Long> {
	
	Song findBySongId(Long songId);
	
	List<Song> findByAlbumId(Long albumId);

}
