package cn.ltysyn.infiniti.mongo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ltysyn.infiniti.common.utils.Response;
import cn.ltysyn.infiniti.common.utils.ReturnCode;
import cn.ltysyn.infiniti.mongo.entity.Album;

@RestController
@RequestMapping(value = "/api/albums")
@CrossOrigin
public class AlbumController extends BaseController {

	@GetMapping
	public Object getAllAlbums() {
		List<Album> albums = albumService.getAllAlbums();
		Response response = new Response(ReturnCode.ARTIST_INFO_GOT, albums);
		return response;
	}
	
}
