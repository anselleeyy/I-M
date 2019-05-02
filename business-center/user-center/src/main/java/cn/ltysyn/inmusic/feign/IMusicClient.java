package cn.ltysyn.inmusic.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import cn.ltysyn.inmusic.commons.Response;

@FeignClient(value = "music-center")
public interface IMusicClient {
	
	@GetMapping
	Response getAllMusics();
	
	@GetMapping(value = "/songs/{id}")
	Response getMusicById(@PathVariable Long id);
	
	@GetMapping(value = "/albums/{albumId}")
	Response getAlbumById(@PathVariable Long albumId);
	
	@GetMapping(value = "/artists/{artistId}")
	Response getArtistId(@PathVariable Integer artistId);

}
