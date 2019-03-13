package cn.ltysyn.inmusic.music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.ltysyn.inmusic.music.service.IAlbumService;
import cn.ltysyn.inmusic.music.service.IArtistService;
import cn.ltysyn.inmusic.music.service.ISongService;

@Component
public class BaseController {
	
	@Autowired
	protected IArtistService artistService;
	
	@Autowired
	protected IAlbumService albumService;
	
	@Autowired
	protected ISongService songService;

}
