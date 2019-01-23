package cn.ltysyn.infiniti.music.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.ltysyn.infiniti.music.entity.Album;
import cn.ltysyn.infiniti.music.service.IAlbumService;

@Service(value = "albumService")
public class AlbumServiceImpl extends BaseService implements IAlbumService {

	@Override
	public List<Album> getAllAlbums() {
		// TODO Auto-generated method stub
		return albumDao.findAll();
	}

	@Override
	public Album getByAlbumId(Long albumId) {
		// TODO Auto-generated method stub
		return albumDao.findByAlbumId(albumId);
	}

}
