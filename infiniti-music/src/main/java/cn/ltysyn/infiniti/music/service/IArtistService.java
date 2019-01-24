package cn.ltysyn.infiniti.music.service;

import java.util.List;

import cn.ltysyn.infiniti.music.entity.Artist;

public interface IArtistService {
	
	List<Artist> getAllArtists();
	
	Artist getByArtistId(Integer artistId);

}
