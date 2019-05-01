package cn.ltysyn.inmusic.music.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.ltysyn.inmusic.music.entity.Song;

public interface ISongDao extends JpaRepository<Song, Long> {
	
	Song findBySongId(Long songId);
	
	List<Song> findByAlbumId(Long albumId);
	
	Page<Song> findAll(Pageable pageable);
	
	@Modifying
	@Query(value = "update t_song set song_name = ?1, lyric = ?2 where song_id = ?3", nativeQuery = true)
	void updateLyricAndSongName(String songName, String lyric, long songId);

}
