package cn.ltysyn.inmusic.music.service;

import java.util.List;

import cn.ltysyn.inmusic.music.entity.Album;

public interface IAlbumService {
	
	List<Album> getAllAlbums();
	
	Album getByAlbumId(Long albumId);
	
	List<Album> getByArtistId(Integer artistId);
	
	List<Album> getByPage(int page, int limit);

}
