package cn.ltysyn.infiniti.mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.ltysyn.infiniti.mongo.service.IArtistService;

@Component
public class BaseController {
	
	@Autowired
	protected IArtistService artistService;

}
