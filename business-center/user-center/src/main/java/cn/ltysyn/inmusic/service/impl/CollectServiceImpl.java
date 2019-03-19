package cn.ltysyn.inmusic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.ltysyn.inmusic.entity.UserCollection;
import cn.ltysyn.inmusic.service.ICollectService;

@Service(value = "collectService")
public class CollectServiceImpl extends BaseService implements ICollectService {

	@Override
	public List<Object> getAllCollectsByUsername(Long userId) {
		// TODO Auto-generated method stub
		List<UserCollection> list = collectDao.findAllByUserId(userId);
		List<Object> musicList = new ArrayList<>();
		list.stream().forEach(info -> {
			musicList.add(musicClient.getMusicById(info.getSongId()).getResult());
		});
		
		return musicList;
	}

}
