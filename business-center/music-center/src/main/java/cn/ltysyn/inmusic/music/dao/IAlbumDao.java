package cn.ltysyn.inmusic.music.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import cn.ltysyn.inmusic.music.entity.Album;

public interface IAlbumDao extends JpaRepository<Album, Long> {
	
	Album findByAlbumId(Long albumId);
	
	List<Album> findByAritstId(Integer artistId);
	
	Page<Album> findAll(Pageable pageable);

}
