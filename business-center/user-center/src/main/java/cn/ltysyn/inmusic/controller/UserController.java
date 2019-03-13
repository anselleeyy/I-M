package cn.ltysyn.inmusic.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.ltysyn.inmusic.entity.User;
import cn.ltysyn.inmusic.service.IUserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@PostMapping(value = "/registry")
	public User createUser(
			@RequestParam("username") String username,
			@RequestParam("password") String password) {
		return userService.createUser(username, password);
	}

}
