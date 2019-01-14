package cn.ltysyn.infiniti.mongo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.ltysyn.infiniti.mongo.entity.Song;
import cn.ltysyn.infiniti.mongo.entity.SongList;
import cn.ltysyn.infiniti.mongo.service.ISongService;

@Service(value = "songService")
public class SongServiceImpl extends BaseService implements ISongService {

	@Override
	public List<Song> getSongsByAlbumId(long albumId) {
		// TODO Auto-generated method stub
		List<Song> songs = new ArrayList<>();
		SongList songList = songDao.findByAlbumId(albumId);
		songs.addAll(songList.getSongs());
		return songs;
	}

}
