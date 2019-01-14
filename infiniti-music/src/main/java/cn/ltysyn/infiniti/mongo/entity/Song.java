package cn.ltysyn.infiniti.mongo.entity;

import org.springframework.data.mongodb.core.mapping.Field;

import cn.ltysyn.infiniti.common.utils.Constant;
import lombok.Data;

@Data
public class Song {
	
	@Field(value = "name")
	private String songName;
	
	@Field(value = "_id")
	private long songId;
	
	private String mp3Url;
	
	private String lyric;
	
	public String getMp3Url() {
		return Constant.NGINX_URL + this.mp3Url;
	}
}