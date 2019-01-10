package cn.ltysyn.infiniti.mongo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.ltysyn.infiniti.mongo.entity.Artist;

public interface IArtistDao extends MongoRepository<Artist, Integer> {
	
	Artist findByArtistName(String artistName);
	
	Artist findByArtistId(int artistId);

}
