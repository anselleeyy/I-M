package cn.ltysyn.inmusic.music.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cn.ltysyn.inmusic.music.entity.Song;
import cn.ltysyn.inmusic.music.service.ISongService;

@Service(value = "songService")
public class SongServiceImpl extends BaseService implements ISongService {

	@Override
	public List<Song> getAll() {
		// TODO Auto-generated method stub
		return songDao.findAll();
	}

	@Override
	public Song getById(Long id) {
		// TODO Auto-generated method stub
		return songDao.findBySongId(id);
	}

	@Override
	public List<Song> getByAlbumId(Long albumId) {
		// TODO Auto-generated method stub
		return songDao.findByAlbumId(albumId);
	}

	@Override
	public Page<Song> getByPage(int page, int limit) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(page-1, limit);
		Page<Song> pageResult = songDao.findAll(pageable);		
//		return pageResult.getContent() == null ? new ArrayList<>() : pageResult.getContent();
		return pageResult;
	}

}
