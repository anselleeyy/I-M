package cn.ltysyn.infiniti.mongo.entity;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Document(collection = "Album")
@Data
public class AlbumList {
	
	@Id
	private ObjectId _id;
	
	@Field(value = "artist_id")
	private int artistId;
	
	@Field(value = "albums")
	private List<Album> albums;

}
