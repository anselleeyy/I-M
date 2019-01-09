package cn.ltysyn.infiniti.mongo.entity;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Song extends BaseEntity {
	
	@Field(value = "name")
	private String songName;
	
	@Field(value = "_id")
	private long songId;
	
	private String mp3Url;
	
	private String lyric;
	
	public String getMp3Url() {
		return NGINX_LOCATION + this.mp3Url;
	}
}