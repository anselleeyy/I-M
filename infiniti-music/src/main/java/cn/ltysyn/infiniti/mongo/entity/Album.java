package cn.ltysyn.infiniti.mongo.entity;

import org.springframework.data.mongodb.core.mapping.Field;

import cn.ltysyn.infiniti.common.utils.Constant;
import lombok.Data;

@Data
public class Album {
	
	@Field(value = "name")
	private String albumName;
	
	@Field(value = "_id")
	private long albumId;
	
	private int size;
	
	private String picUrl;
	
	private String publishTime;
	
	private String commentThreadId;
	
	private String description;;
	
	private String tags;
	
	private String company;
	
	public String getPicUrl() {
		return Constant.NGINX_URL + this.picUrl;
	}
}
