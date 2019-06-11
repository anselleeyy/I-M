package cn.ltysyn.inmusic.music.service;

import java.util.List;

import org.springframework.data.domain.Page;

import cn.ltysyn.inmusic.music.entity.Album;

public interface IAlbumService {
	
	List<Album> getAllAlbums();
	
	Album getByAlbumId(Long albumId);
	
	List<Album> getByArtistId(Integer artistId);
	
	List<Album> getByPage(int page, int limit);
	
	List<Album> getByPageOrderByPublishTime(int page, int limit);
	
	List<Album> searchAlbum(String keyword);
	
	Page<Album> getAllByPage(int page, int limit);
	
	boolean addAlbum(Album album);
	
	boolean delAlbum(long albumId);

}
