package cn.ltysyn.inmusic.music.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.ltysyn.inmusic.music.entity.Artist;

public interface IArtistDao extends JpaRepository<Artist, Integer> {
	
	Artist findByArtistId(Integer artistId);
	
	Page<Artist> findAll(Pageable pageable);
	
	@Query(value = "select * from t_artist where artist_name like ?1 limit 5", nativeQuery = true)
	List<Artist> findByArtistNameLike(String keyword);

}
