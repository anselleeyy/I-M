package cn.ltysyn.infiniti.mongo.entity;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "Song")
public class SongList {
	
	private ObjectId _id;
	
	@Field(value = "album_id")
	private long albumId;
	
	@Field(value = "songs")
	private List<Song> songs;	

}
