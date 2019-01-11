package cn.ltysyn.infiniti.mongo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.ltysyn.infiniti.common.utils.Response;
import cn.ltysyn.infiniti.common.utils.ReturnCode;
import cn.ltysyn.infiniti.mongo.entity.Artist;
import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/api/artists")
@Api(value = "歌手 Controller")
public class ArtistController extends BaseController {
	
	@GetMapping
	public Object getAllArtists() {
		List<Artist> artists = artistService.getAllArtists();
		Response response = new Response(ReturnCode.ARTIST_INFO_GOT, artists);
		return response.getJsonString();
	}
	
	@GetMapping(value = "/", params = "artistName")
	public Object getArtistByName(@RequestParam(value = "artistName", defaultValue = "", required = true) String artistName) {
		Artist artist = artistService.getArtistByArtistName(artistName);
		Response response = new Response(ReturnCode.ARTIST_INFO_GOT, artist);
		return response.getJsonString();
	}
	
	@GetMapping(value = "/", params = "artistId")
	public Object getArtistById(@RequestParam(value = "artistId", required = true) int artistId) {
		Artist artist = artistService.getArtistByArtistId(artistId);
		Response response = new Response(ReturnCode.ARTIST_INFO_GOT, artist);
		return response.getJsonString();
	}

}
