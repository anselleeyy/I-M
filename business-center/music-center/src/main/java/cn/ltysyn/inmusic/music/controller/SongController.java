package cn.ltysyn.inmusic.music.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.ltysyn.inmusic.commons.Response;
import cn.ltysyn.inmusic.commons.ReturnCode;
import cn.ltysyn.inmusic.music.entity.Song;
import cn.ltysyn.inmusic.music.utils.FileUpload;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/songs")
@Api(value = "歌曲控制器")
public class SongController extends BaseController {
	
	private static AtomicLong songId = new AtomicLong(10000000000L);
	
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
	
	/**
	 * 上传音乐文件，并返回相对路径
	 * 
	 * @param file
	 * @param albumId
	 * @param artistId
	 * @return
	 */
	@PostMapping(value = "/upload")
	public Object uploadSongs(@RequestParam MultipartFile file, @RequestParam long albumId, @RequestParam long artistId) {
		String mp3Url = "";
		try {
			mp3Url = FileUpload.saveMp3(artistId, albumId, file);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return mp3Url;
	}
	
	/**
	 * 音乐数据的存储
	 * 使用 AtomicLong 生成音乐id, 保证线程安全
	 * 
	 * @param song
	 * @return
	 */
	@PostMapping(value = "/add")
	public Object addSongs(@RequestBody Song song) {
		song.setSongId(songId.getAndAdd(1));
		Response response = null;
		boolean flag = songService.addSong(song);
		if (flag) {
			response = new Response(ReturnCode.SONG_ADD_SUCCEED);
		} else {
			response = new Response(ReturnCode.SONG_ADD_FAILED);
		}
		return response;
	}
	
	/**
	 * 更新歌曲的名称和歌词
	 * 
	 * @param song
	 * @return
	 */
	@PatchMapping(value = "/update/{songId}")
	public Object updateSong(@RequestBody Song song, @PathVariable long songId) {
		Response response = null;
		boolean flag = songService.updateSong(song, songId);
		if (flag) {
			response = new Response(ReturnCode.SONG_UPDATE_SUCCEED);
		} else {
			response = new Response(ReturnCode.SONG_UPDATE_FAILED);
		}
		return response;
	}
	
	/**
	 * 搜索接口
	 * 
	 * @param keyword
	 * @return
	 */
	@GetMapping(value = "/search")
	public Object searchSong(@RequestParam String keyword) {
		List<Song> songs = songService.searchSong("%" + keyword + "%");
		Response response = new Response(ReturnCode.SONG_INFO_GOT, songs);
		return response;
	}
	
	@DeleteMapping(value = "/delete/{songId}")
	public Object deleteSong(@PathVariable long songId) {
		Response response = null;
		boolean flag = songService.delSong(songId);
		if (flag) {
			response = new Response(ReturnCode.SONG_DELETE_SUCCEED);
		} else {
			response = new Response(ReturnCode.SONG_DELETE_FAILED);
		}
		return response;
	}

}
