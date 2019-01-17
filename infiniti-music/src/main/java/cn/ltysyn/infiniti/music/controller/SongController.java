package cn.ltysyn.infiniti.music.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ltysyn.infiniti.music.entity.Song;

@RestController
@RequestMapping(value = "/songs")
public class SongController extends BaseController {
	
	@GetMapping(value = "/all")
	public Object getAllSongs() {
		List<Song> list = songService.getAllSongs();
		System.out.println(list);
		return list;
	}

}
