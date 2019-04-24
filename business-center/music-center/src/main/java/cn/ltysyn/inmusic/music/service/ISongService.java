package cn.ltysyn.inmusic.music.service;

import java.util.List;

import cn.ltysyn.inmusic.music.entity.Song;

public interface ISongService {
	
	List<Song> getAll();
	
	Song getById(Long id);
	
	List<Song> getByAlbumId(Long albumId);
	
	List<Song> getByPage(int page, int limit);

}
