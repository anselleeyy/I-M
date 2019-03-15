package cn.ltysyn.inmusic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ltysyn.inmusic.entity.User;
import cn.ltysyn.inmusic.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
@Api(tags = "用户登录注册接口类")
public class UserController {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private IUserService userService;
	
	@PostMapping(value = "/register")
	@ApiOperation(value = "用户注册")
	public Object createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@ApiOperation(value = "用户登录", notes = "根据用户传递的用户名和密码进行登录校验")
	@PostMapping(value = "/login")
	public Object findByUsername(@RequestBody User user) {
		LOG.info("用户登录: {}", user);
        user = userService.checkLogin(user);
        return user;
    }
	
	@GetMapping(value = "/hi")
	public Object testForToken() {
		return "hi, you're authorized";
    }

}
