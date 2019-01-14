package cn.ltysyn.infiniti.mongo.service;

import java.util.List;

import cn.ltysyn.infiniti.mongo.entity.Song;

public interface ISongService {
	
	/**
	 * 通过专辑 Id 获取专辑内音乐列表
	 * created by liyaoyu on 2019.01.14
	 * @param albumId
	 * @return
	 */
	public List<Song> getSongsByAlbumId(long albumId);

}
