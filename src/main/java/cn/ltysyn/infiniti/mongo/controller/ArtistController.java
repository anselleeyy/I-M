package cn.ltysyn.infiniti.mongo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ltysyn.infiniti.mongo.entity.Artist;

@RestController
@RequestMapping(value = "/artist")
public class ArtistController extends BaseController {
	
	@GetMapping(value = "/")
	public List<Artist> getAllArtists() {
		return artistService.getAllArtists();
	}

}
