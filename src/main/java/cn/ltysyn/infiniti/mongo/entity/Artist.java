package cn.ltysyn.infiniti.mongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Document(collection = "Artist")
@Data
public class Artist {
	
	@Field(value = "name")
	private String artistName;
	
	@Id
	@Field(value = "_id")
	private int artistId;
	
	private String picUrl;

}
