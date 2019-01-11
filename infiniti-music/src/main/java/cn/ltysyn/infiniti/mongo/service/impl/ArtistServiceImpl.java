package cn.ltysyn.infiniti.mongo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.ltysyn.infiniti.mongo.entity.Artist;
import cn.ltysyn.infiniti.mongo.service.IArtistService;

@Service(value = "artistService")
public class ArtistServiceImpl extends BaseService implements IArtistService {

	@Override
	public List<Artist> getAllArtists() {
		// TODO Auto-generated method stub
		return artistDao.findAll();
	}

	@Override
	public Artist getArtistByArtistName(String artistName) {
		// TODO Auto-generated method stub
		return artistDao.findByArtistName(artistName);
	}

	@Override
	public Artist getArtistByArtistId(int artistId) {
		// TODO Auto-generated method stub
		return artistDao.findByArtistId(artistId);
	}

}
