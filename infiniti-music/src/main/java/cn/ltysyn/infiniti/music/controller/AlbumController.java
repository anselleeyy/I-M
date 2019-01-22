package cn.ltysyn.infiniti.music.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ltysyn.infiniti.music.entity.Album;

@RestController
@CrossOrigin
@RequestMapping(value = "/albums")
public class AlbumController extends BaseController {
	
	@GetMapping
	public Object getAllAlbums() {
		List<Album> list = albumService.getAllAlbums();
		return list;
	}

}
