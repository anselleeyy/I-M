package cn.ltysyn.infiniti.mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import cn.ltysyn.infiniti.mongo.service.IAlbumService;
import cn.ltysyn.infiniti.mongo.service.IArtistService;
import cn.ltysyn.infiniti.mongo.service.ISongService;

@Component
public class BaseController {
	
	@Autowired
	protected IArtistService artistService;
	
	@Autowired
	protected IAlbumService albumService;
	
	@Autowired
	protected ISongService songService;

}
