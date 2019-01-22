package cn.ltysyn.infiniti.music.service;

import java.util.List;

import cn.ltysyn.infiniti.music.entity.Song;

public interface ISongService {
	
	List<Song> getAll();
	
	Song getById(Long id);

}
