package cn.ltysyn.inmusic.music.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.ltysyn.inmusic.music.entity.Album;

public interface IAlbumDao extends JpaRepository<Album, Long> {
	
	Album findByAlbumId(Long albumId);
	
	List<Album> findByAritstId(Integer artistId);
	
	Page<Album> findAll(Pageable pageable);
	
	Page<Album> findByOrderByPublishTimeDesc(Pageable pageable);
	
	@Query(value = "select * from t_album where album_name like ?1 limit 5", nativeQuery = true)
	List<Album> findByAlbumNameLike(String keyword);

}
