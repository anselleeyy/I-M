package cn.ltysyn.infiniti.music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.ltysyn.infiniti.music.service.IAlbumService;
import cn.ltysyn.infiniti.music.service.IArtistService;
import cn.ltysyn.infiniti.music.service.ISongService;

@Component
public class BaseController {
	
	@Autowired
	protected IArtistService artistService;
	
	@Autowired
	protected IAlbumService albumService;
	
	@Autowired
	protected ISongService songService;

}
