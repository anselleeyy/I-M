package cn.ltysyn.inmusic.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ltysyn.inmusic.commons.Response;
import cn.ltysyn.inmusic.commons.ReturnCode;
import cn.ltysyn.inmusic.entity.UserCollection;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/collect")
@Api(tags = "用户收藏接口类")
public class CollectController extends BaseController {
	
	private static final Logger LOG = LoggerFactory.getLogger(CollectController.class);
	
	@GetMapping(value = "/{userId}")
	@ApiOperation(value = "查询用户收藏列表", notes = "通过 userId 得到用户的收藏列表")
	public Object getAllCollects(@PathVariable Long userId) {
		List<Object> collects = collectService.getAllCollectsByUsername(userId);
		Response response = new Response(ReturnCode.USER_COLLECTS_GOT, collects);
		LOG.info("用户: {} 收藏列表: {}", userId, collects);
		return response;
	}
	
	@PostMapping(value = "/add")
	public Object addCollect(@RequestBody UserCollection collection) {
		Response response = null;
		boolean flag = collectService.addCollect(collection);
		if (flag) {
			response = new Response(ReturnCode.USER_COLLECT_SUCCEED);
		} else {
			response = new Response(ReturnCode.USER_COLLECT_FAILED);
		}
		return response;
	}
	
	@DeleteMapping(value = "/delete")
	public Object deleteCollect(@RequestBody UserCollection collection) {
		Response response = null;
		boolean flag = collectService.deleteCollect(collection);
		if (flag) {
			response = new Response(ReturnCode.USER_DEL_COLLECT_SUCCEED);
		} else {
			response = new Response(ReturnCode.USER_DEL_COLLECT_FAILED);
		}
		return response;
	}

}
