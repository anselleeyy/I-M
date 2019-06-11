package cn.ltysyn.inmusic.music.controller;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.collect.Maps;

import cn.ltysyn.inmusic.commons.Response;
import cn.ltysyn.inmusic.commons.ReturnCode;
import cn.ltysyn.inmusic.music.entity.Album;
import cn.ltysyn.inmusic.music.entity.Song;
import cn.ltysyn.inmusic.music.utils.FileUpload;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/albums")
@Api(value = "专辑控制器")
public class AlbumController extends BaseController {
	
	private static AtomicLong albumId = new AtomicLong(1000000000L);
	
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
	
	/**
	 * 根据 publishTime 降序搜索
	 * @param limit
	 * @return
	 */
	@GetMapping(value = "/page/time")
	public Object getAlbumsOrderByPublishTime(@RequestParam int page, @RequestParam int size) {
		List<Album> albums = albumService.getByPageOrderByPublishTime(page, size);
		Response response = new Response(ReturnCode.ALBUM_LIST_GOT, albums);
		return response;
	}
	
	/**
	 * 专辑搜索接口
	 * 
	 * @param keyword
	 * @return
	 */
	@GetMapping(value = "/search")
	public Object searchAlbum(@RequestParam String keyword) {
		List<Album> list = albumService.searchAlbum("%" + keyword + "%");
		Response response = new Response(ReturnCode.ALBUM_LIST_GOT, list);
		return response;
	}
	
	/**
	 * 分页查询接口
	 */
	@GetMapping(value = "/page")
	public Object getAlbumsByPage(@RequestParam int page, @RequestParam int size) {
		Page<Album> albums = albumService.getAllByPage(page, size);
		Response response = new Response(ReturnCode.ALBUM_LIST_GOT, albums);
		return response;
	}
	
	@PostMapping(value = "/upload")
	public Object uploadPic(@RequestParam MultipartFile file, @RequestParam long artistId) {
		Map<String, Object> map = Maps.newHashMap();
		try {
			long id = albumId.getAndAdd(1);
			String picUrl = FileUpload.savePic(artistId, id, file);
			map.put("albumId", id);
			map.put("picUrl", picUrl);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return map;
	}
	
	@PostMapping(value = "/add")
	public Object add(@RequestBody Album album) {
		Response response = null;
		boolean flag = albumService.addAlbum(album);
		if (flag) {
			response = new Response(ReturnCode.ALBUM_ADD_SUCCEED);
		} else {
			response = new Response(ReturnCode.ALBUM_ADD_FAILED);
		}
		return response;
	}
	
	@DeleteMapping(value = "/delete/{albumId}")
	public Object deleteSong(@PathVariable long albumId) {
		Response response = null;
		boolean flag = albumService.delAlbum(albumId);
		if (flag) {
			response = new Response(ReturnCode.ALBUM_DELETE_SUCCEED);
		} else {
			response = new Response(ReturnCode.ALBUM_DELETE_FAILED);
		}
		return response;
	}

}
