package cn.ltysyn.inmusic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ltysyn.inmusic.entity.User;
import cn.ltysyn.inmusic.service.IUserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private IUserService userService;
	
	@PostMapping(value = "/register")
	public Object createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@PostMapping(value = "/login")
	public Object findByUsername(@RequestBody User user) {
		LOG.info("用户登录: {}", user);
        user = userService.checkLogin(user);
        return user;
    }

}
