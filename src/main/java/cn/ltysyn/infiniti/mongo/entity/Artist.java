package cn.ltysyn.infiniti.mongo.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Document(collection = "Artist")
@Data
public class Artist implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3654251917402225590L;

	@Field(value = "name")
	private String artistName;
	
	@Id
	@Field(value = "_id")
	private int artistId;
	
	private String picUrl;

}
