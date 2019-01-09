package cn.ltysyn.infiniti.mongo.entity;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Album extends BaseEntity {
	
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
		return NGINX_LOCATION + this.picUrl;
	}
}
