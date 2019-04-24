package cn.ltysyn.inmusic.music.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ltysyn.inmusic.commons.Response;
import cn.ltysyn.inmusic.commons.ReturnCode;
import cn.ltysyn.inmusic.music.entity.Album;
import cn.ltysyn.inmusic.music.entity.Artist;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/artists")
@Api(value = "歌手控制器")
public class ArtistController extends BaseController {
	
	@GetMapping
	@ApiOperation(value = "查询所有歌手列表")
	public Object getAllArtists() {
		List<Artist> artists = artistService.getAllArtists();
		Response response = new Response(ReturnCode.ARTIST_LIST_GOT, artists);
		return response;
	}
	
	@GetMapping(value = "/{artistId}")
	@ApiOperation(value = "查询单个歌手信息", notes = "根据歌手 id 查询歌手信息")
	public Object getArtistById(@PathVariable Integer artistId) {
		Artist artist = artistService.getByArtistId(artistId);
		Response response = new Response(ReturnCode.ARTIST_INFO_GOT, artist);
		return response;
	}
	
	@GetMapping(value = "/{artistId}/albums")
	@ApiOperation(value = "查询该歌手下的专辑信息", notes = "根据歌手 id 查询该歌手下的专辑信息")
	public Object getAlbumsByArtistId(@PathVariable Integer artistId) {
		List<Album> albums = albumService.getByArtistId(artistId);
		Response response = new Response(ReturnCode.ALBUMS_IN_ARTIST_GOT, albums);
		return response;
	}

}
