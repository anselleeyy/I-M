package cn.ltysyn.inmusic.music.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ltysyn.inmusic.music.entity.Album;
import cn.ltysyn.inmusic.music.entity.Artist;
import cn.ltysyn.inmusic.music.entity.Song;
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

	@Override
	public Page<Artist> getByPage(int page, int limit) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(page-1, limit);
		return artistDao.findAll(pageable);
	}

	@Override
	@Transactional
	public boolean addArtist(Artist artist) {
		// TODO Auto-generated method stub
		try {
			artistDao.save(artist);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	@Transactional
	public boolean delArtist(int artistId) {
		// TODO Auto-generated method stub
		try {
			// 删除歌手
			artistDao.deleteById(artistId);
			// 删除歌手下的所有专辑
			List<Album> albums = albumDao.findByAritstId(artistId);
			albums.stream().forEach(album -> {
				albumDao.deleteById(album.getAlbumId());
				// 删除专辑下的所有歌曲
				List<Song> songs = songDao.findByAlbumId(album.getAlbumId());
				songs.stream().forEach(song -> {
					songDao.deleteById(song.getSongId());
				});
			});
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

}
