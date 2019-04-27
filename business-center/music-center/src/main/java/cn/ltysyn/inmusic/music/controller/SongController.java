package cn.ltysyn.inmusic.music.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.ltysyn.inmusic.commons.Response;
import cn.ltysyn.inmusic.commons.ReturnCode;
import cn.ltysyn.inmusic.music.entity.Song;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/songs")
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
	
	@GetMapping(value = "/hot/{limit}")
	@ApiOperation(value = "查询top歌曲", notes = "根据 limit 参数查询热门歌曲")
	public Object getHotSongs(@PathVariable int limit) {
		List<Song> songs = new ArrayList<>();
		songs = songService.getByPage(1, limit).getContent();
		Response response = new Response(ReturnCode.SONG_INFO_GOT, songs);
		return response;
	}
	
	@GetMapping(value = "/page")
	public Object getSongsByPage(@RequestParam int page, @RequestParam int size) {
		Page<Song> songs = songService.getByPage(page, size);
		Response response = new Response(ReturnCode.SONG_INFO_GOT, songs);
		return response;
	}

}
