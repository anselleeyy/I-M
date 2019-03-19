package cn.ltysyn.inmusic.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.ltysyn.inmusic.commons.Response;

@FeignClient(value = "music-center")
@RequestMapping(value = "/songs")
public interface IMusicClient {
	
	@GetMapping
	Response getAllMusics();
	
	@GetMapping(value = "/{id}")
	Response getMusicById(@PathVariable Long id);
	
	

}
