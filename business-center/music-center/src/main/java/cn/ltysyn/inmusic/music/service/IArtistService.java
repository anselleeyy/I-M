package cn.ltysyn.inmusic.music.service;

import java.util.List;

import org.springframework.data.domain.Page;

import cn.ltysyn.inmusic.music.entity.Artist;

public interface IArtistService {
	
	List<Artist> getAllArtists();
	
	Artist getByArtistId(Integer artistId);
	
	List<Artist> searchArtist(String keyword);
	
	Page<Artist> getByPage(int page, int limit);
	
	boolean addArtist(Artist artist);
	
	boolean delArtist(int artistId);

}
