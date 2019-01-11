package cn.ltysyn.infiniti.mongo.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import cn.ltysyn.infiniti.mongo.entity.SongList;

public interface ISongDao extends MongoRepository<SongList, ObjectId> {
	
	SongList findByAlbumId(long albumId);

}
