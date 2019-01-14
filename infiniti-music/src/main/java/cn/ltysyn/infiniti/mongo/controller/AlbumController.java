package cn.ltysyn.infiniti.mongo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ltysyn.infiniti.common.utils.Response;
import cn.ltysyn.infiniti.common.utils.ReturnCode;
import cn.ltysyn.infiniti.mongo.entity.Album;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/albums")
@CrossOrigin
@Api(value = "专辑控制器")
public class AlbumController extends BaseController {

	@GetMapping
	@ApiOperation(value = "获取所有专辑列表")
	public Object getAllAlbums() {
		List<Album> albums = albumService.getAllAlbums();
		Response response = new Response(ReturnCode.ALBUM_LIST_GOT, albums);
		return response;
	}
	
}
