package cn.ltysyn.infiniti.music.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ltysyn.infiniti.common.utils.Response;
import cn.ltysyn.infiniti.common.utils.ReturnCode;
import cn.ltysyn.infiniti.music.entity.Song;

@RestController
@RequestMapping(value = "/songs")
public class SongController extends BaseController {
	
	@GetMapping
	public Object getAllSongs() {
		List<Song> list = songService.getAll();
		System.out.println(list);
		return list;
	}
	
	@GetMapping(value = "/{id}")
	public Object getSongById(@PathVariable Long id) {
		Song song = songService.getById(id);
		Response response = new Response(ReturnCode.SONG_INFO_GOT, song);
		return response;
	}

}
