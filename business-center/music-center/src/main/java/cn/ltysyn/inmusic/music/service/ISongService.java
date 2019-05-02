package cn.ltysyn.inmusic.music.service;

import java.util.List;

import org.springframework.data.domain.Page;

import cn.ltysyn.inmusic.music.entity.Song;

public interface ISongService {
	
	List<Song> getAll();
	
	Song getById(Long id);
	
	List<Song> getByAlbumId(Long albumId);
	
	Page<Song> getByPage(int page, int limit);
	
	boolean addSong(Song song);
	
	boolean updateSong(Song song, long songId);
	
	List<Song> searchSong(String keyword);

}
