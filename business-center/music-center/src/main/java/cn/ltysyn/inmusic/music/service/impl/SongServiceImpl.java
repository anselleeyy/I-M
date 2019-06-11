package cn.ltysyn.inmusic.music.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		return pageResult;
	}

	@Override
	public boolean addSong(Song song) {
		// TODO Auto-generated method stub
		try {
			songDao.save(song);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	@Transactional
	public boolean updateSong(Song song, long songId) {
		// TODO Auto-generated method stub
		try {
			String songName = song.getSongName();
			String lyric = song.getLyric();
			songDao.updateLyricAndSongName(songName, lyric, songId);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Song> searchSong(String keyword) {
		// TODO Auto-generated method stub
		return songDao.findBySongNameLike(keyword);
	}

	@Override
	@Transactional
	public boolean delSong(long songId) {
		// TODO Auto-generated method stub
		try {
			songDao.deleteById(songId);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

}
