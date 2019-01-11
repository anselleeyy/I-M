package cn.ltysyn.infiniti.mongo.service;

import java.util.List;

import cn.ltysyn.infiniti.mongo.entity.Artist;

public interface IArtistService {
	
	public List<Artist> getAllArtists();
	
	Artist getArtistByArtistName(String artistName);
	
	Artist getArtistByArtistId(int artistId);

}
