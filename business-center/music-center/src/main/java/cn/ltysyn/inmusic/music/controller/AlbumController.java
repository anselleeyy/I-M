package cn.ltysyn.inmusic.music.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ltysyn.inmusic.commons.Response;
import cn.ltysyn.inmusic.commons.ReturnCode;
import cn.ltysyn.inmusic.music.entity.Album;
import cn.ltysyn.inmusic.music.entity.Song;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/albums")
@Api(value = "专辑控制器")
public class AlbumController extends BaseController {
	
	@GetMapping
	@ApiOperation(value = "获取所有的专辑列表")
	public Object getAllAlbums() {
		List<Album> list = albumService.getAllAlbums();
		Response response = new Response(ReturnCode.ALBUM_LIST_GOT, list);
		return response;
	}
	
	@GetMapping(value = "/{albumId}")
	@ApiOperation(value = "获取专辑信息", notes = "根据专辑 id 获取专辑信息")
	public Object getAlbumById(@PathVariable Long albumId) {
		Album album = albumService.getByAlbumId(albumId);
		Response response = new Response(ReturnCode.ALBUM_INFO_GOT, album);
		return response;
	}
	
	@GetMapping(value = "/{albumId}/songs")
	@ApiOperation(value = "获取专辑内音乐列表", notes = "根据专辑 id 获取专辑内音乐列表")
	public Object getSongsByAlbumId(@PathVariable Long albumId) {
		List<Song> songs = songService.getByAlbumId(albumId);
		Response response = new Response(ReturnCode.SONGS_IN_ALBUM_GOT, songs);
		return response;
	}
	
	@GetMapping(value = "/hot/{limit}")
	@ApiOperation(value = "查询top专辑", notes = "根据 limit 参数查询热门专辑")
	public Object getHotAlbums(@PathVariable int limit) {
		List<Album> albums = albumService.getByPage(1, limit);
		Response response = new Response(ReturnCode.ALBUM_LIST_GOT, albums);
		return response;
	}

}
