package cn.ltysyn.infiniti.mongo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ltysyn.infiniti.common.utils.Response;
import cn.ltysyn.infiniti.common.utils.ReturnCode;
import cn.ltysyn.infiniti.mongo.entity.Song;
import io.swagger.annotations.Api;

@RequestMapping(value = "/songs")
@RestController
@CrossOrigin
@Api(value = "歌曲控制器")
public class SongController extends BaseController {
	
	@GetMapping(value = "/{albumId}")
	public Object getSongsByAlbumId(@PathVariable long albumId) {
		List<Song> songs = songService.getSongsByAlbumId(albumId);
		Response response = new Response(ReturnCode.SONGS_IN_ALBUM_GOT, songs);
		return response;
	}

}
