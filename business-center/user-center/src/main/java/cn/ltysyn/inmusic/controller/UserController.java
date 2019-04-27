package cn.ltysyn.inmusic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.ltysyn.inmusic.commons.Response;
import cn.ltysyn.inmusic.commons.ReturnCode;
import cn.ltysyn.inmusic.dto.PwdDto;
import cn.ltysyn.inmusic.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/user")
@Api(tags = "用户接口类")
public class UserController extends BaseController {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping(value = "/register")
	@ApiOperation(value = "用户注册")
	public Object createUser(@RequestBody User user) {
		LOG.info("register user: {}", user);
		user = userService.createUser(user);
		Response response;
		if (user != null) {
			response = new Response(ReturnCode.USER_CREATE_SUCCEED, user);
		} else {
			response = new Response(ReturnCode.USER_REGISTER_ERROR);
		}
		return response;
	}
	
	@ApiOperation(value = "用户登录", notes = "根据用户传递的用户名和密码进行登录校验")
	@PostMapping(value = "/login")
	public Object findByUsername(@RequestBody User user) {
		LOG.info("用户登录: {}", user);
        user = userService.checkLogin(user);
        Response response;
        if (user != null) {
			response = new Response(ReturnCode.USER_LOGIN_SUCCEED, user);
		} else {
			response = new Response(ReturnCode.USER_LOGIN_FAILED);
		}
        return response;
    }
	
	@PatchMapping(value = "/updatePwd/{id}")
	public Object updatePassword(@PathVariable Long id, @RequestBody PwdDto pwdDto) {
		boolean flag = userService.updatePassword(id, pwdDto);
		Response response = new Response();
		if (flag) {
			response.setReturnCode(ReturnCode.USER_PASSWORD_UPDATE_SUCCEED);
		} else {
			response.setReturnCode(ReturnCode.USER_PASSWORD_UPDATE_FAILED);
		}
		return response;
	}
	
	@GetMapping(value = "/page")
	public Object findAll(@RequestParam int page, @RequestParam int size) {
		Page<User> users = userService.findAll(page, size);
		Response response = new Response(ReturnCode.USER_LIST_GOT, users);
		return response;
	}
	
	@GetMapping(value = "/hi")
	public Object testForToken() {
		return "hi, you're authorized";
    }
	
}
