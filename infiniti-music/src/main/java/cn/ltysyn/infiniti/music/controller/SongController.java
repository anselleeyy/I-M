package cn.ltysyn.infiniti.music.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ltysyn.infiniti.common.utils.Response;
import cn.ltysyn.infiniti.common.utils.ReturnCode;
import cn.ltysyn.infiniti.music.entity.Song;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/songs")
@CrossOrigin
@Api(value = "歌曲控制器")
public class SongController extends BaseController {
	
	@GetMapping
	@ApiOperation(value = "查询所有音乐列表")
	public Object getAllSongs() {
		List<Song> songs = songService.getAll();
		Response response = new Response(ReturnCode.SONG_LIST_GOT, songs);
		return response;
	}
	
	@GetMapping(value = "/{id}")
	@ApiOperation(value = "查询单个音乐信息", notes = "根据音乐 id 查询音乐信息")
	public Object getSongById(@PathVariable Long id) {
		Song song = songService.getById(id);
		Response response = new Response(ReturnCode.SONG_INFO_GOT, song);
		return response;
	}

}
