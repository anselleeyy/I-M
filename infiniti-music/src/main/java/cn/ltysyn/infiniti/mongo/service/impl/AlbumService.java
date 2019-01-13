package cn.ltysyn.infiniti.mongo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.ltysyn.infiniti.mongo.entity.Album;
import cn.ltysyn.infiniti.mongo.entity.AlbumList;
import cn.ltysyn.infiniti.mongo.service.IAlbumService;

@Service(value = "albumService")
public class AlbumService extends BaseService implements IAlbumService {

	@Override
	public List<Album> getAllAlbums() {
		// TODO Auto-generated method stub
		List<Album> albums = new ArrayList<>();
		List<AlbumList> list = albumDao.findAll();
		for (AlbumList albumList : list) {
			albums.addAll(albumList.getAlbums());
		}
		return albums;
	}

}
