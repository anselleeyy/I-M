package cn.ltysyn.infiniti.mongo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.ltysyn.infiniti.common.utils.Response;
import cn.ltysyn.infiniti.common.utils.ReturnCode;
import cn.ltysyn.infiniti.mongo.entity.Artist;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/artists")
@Api(value = "歌手控制器")
public class ArtistController extends BaseController {
	
	@GetMapping
	@ApiOperation(value = "获取所有歌手列表")
	public Object getAllArtists() {
		List<Artist> artists = artistService.getAllArtists();
		Response response = new Response(ReturnCode.ARTIST_LIST_GOT, artists);
		return response;
	}
	
	@GetMapping(value = "/", params = "artistName")
	@ApiOperation(value = "获取歌手详细信息", notes = "根据歌手姓名获取歌手详细信息")
	@ApiImplicitParam(name = "artistName", value = "歌手姓名", required = true, dataType = "String")
	public Object getArtistByName(@RequestParam(value = "artistName", defaultValue = "", required = true) String artistName) {
		Artist artist = artistService.getArtistByArtistName(artistName);
		Response response = new Response(ReturnCode.ARTIST_INFO_GOT, artist);
		return response;
	}
	
	@GetMapping(value = "/{artistId}")
	@ApiOperation(value = "获取歌手详细信息", notes = "根据歌手 id 获取歌手详细信息")
	@ApiParam(name = "artistId", value = "歌手 id", required = true)
	public Object getArtistById(@PathVariable int artistId) {
		Artist artist = artistService.getArtistByArtistId(artistId);
		Response response = new Response(ReturnCode.ARTIST_INFO_GOT, artist);
		return response;
	}

}
