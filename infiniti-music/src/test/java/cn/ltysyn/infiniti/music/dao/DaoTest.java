package cn.ltysyn.infiniti.music.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.ltysyn.infiniti.music.entity.Song;
import cn.ltysyn.infiniti.music.service.ISongService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DaoTest {
	
	@Autowired
	private ISongService songService;
	
	@Test
	public void findSongs() {
		
		List<Song> songs = songService.getAllSongs();
		System.out.println(songs);
		
	}
	
}