package cn.ltysyn.inmusic.controller;

import org.springframework.beans.factory.annotation.Autowired;

import cn.ltysyn.inmusic.service.ICollectService;
import cn.ltysyn.inmusic.service.IUserService;

public class BaseController {
	
	@Autowired
	protected IUserService userService;
	
	@Autowired
	protected ICollectService collectService;

}
