package cn.ltysyn.infiniti.music.service;

import java.util.List;

import cn.ltysyn.infiniti.music.entity.Album;

public interface IAlbumService {
	
	List<Album> getAllAlbums();
	
	Album getByAlbumId(Long albumId);

}
