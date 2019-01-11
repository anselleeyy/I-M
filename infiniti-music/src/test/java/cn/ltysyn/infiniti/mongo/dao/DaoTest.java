package cn.ltysyn.infiniti.mongo.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.ltysyn.infiniti.mongo.entity.AlbumList;
import cn.ltysyn.infiniti.mongo.entity.Album;
import cn.ltysyn.infiniti.mongo.entity.Song;
import cn.ltysyn.infiniti.mongo.entity.SongList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DaoTest {
	
	@Autowired
	private IAlbumDao albumDao;
	
	@Autowired
	private IArtistDao artistDao;
	
	@Autowired
	private ISongDao songDao;
	
	@Test
	public void findSongsByArtist() {
		
		String artist_name = "李荣浩";
		int artist_id = artistDao.findByArtistName(artist_name).getArtistId();
		System.out.println(artist_id);
		
		AlbumList albumList = albumDao.findByArtistId(artist_id);
		System.out.println(albumList);
		List<Album> albums = albumList.getAlbums();
		Album album = albums.get(0);
		
		long album_id = album.getAlbumId();
		System.out.println(album_id);
		SongList songList = songDao.findByAlbumId(album_id);
		List<Song> songs = songList.getSongs();
		System.out.println(songs.get(0));
		
	}
	
}