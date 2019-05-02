package cn.ltysyn.inmusic.music.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.ltysyn.inmusic.music.entity.Artist;
import cn.ltysyn.inmusic.music.service.IArtistService;

@Service(value = "artistService")
public class ArtistServiceImpl extends BaseService implements IArtistService {

	@Override
	public List<Artist> getAllArtists() {
		// TODO Auto-generated method stub
		return artistDao.findAll();
	}

	@Override
	public Artist getByArtistId(Integer artistId) {
		// TODO Auto-generated method stub
		return artistDao.findByArtistId(artistId);
	}

	@Override
	public List<Artist> searchArtist(String keyword) {
		// TODO Auto-generated method stub
		return artistDao.findByArtistNameLike(keyword);
	}

}
