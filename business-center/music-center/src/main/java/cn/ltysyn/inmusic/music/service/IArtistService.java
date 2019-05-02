package cn.ltysyn.inmusic.music.service;

import java.util.List;

import cn.ltysyn.inmusic.music.entity.Artist;

public interface IArtistService {
	
	List<Artist> getAllArtists();
	
	Artist getByArtistId(Integer artistId);
	
	List<Artist> searchArtist(String keyword);

}
