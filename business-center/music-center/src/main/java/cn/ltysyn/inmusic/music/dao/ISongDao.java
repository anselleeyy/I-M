package cn.ltysyn.inmusic.music.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import cn.ltysyn.inmusic.music.entity.Song;

public interface ISongDao extends JpaRepository<Song, Long> {
	
	Song findBySongId(Long songId);
	
	List<Song> findByAlbumId(Long albumId);
	
	Page<Song> findAll(Pageable pageable);

}
