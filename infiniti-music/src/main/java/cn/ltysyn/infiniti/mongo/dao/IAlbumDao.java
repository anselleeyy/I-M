package cn.ltysyn.infiniti.mongo.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import cn.ltysyn.infiniti.mongo.entity.AlbumList;

public interface IAlbumDao extends MongoRepository<AlbumList, ObjectId> {
	
	AlbumList findByArtistId(int artistId);

}
