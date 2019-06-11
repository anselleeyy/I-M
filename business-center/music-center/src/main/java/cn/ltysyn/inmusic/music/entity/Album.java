package cn.ltysyn.inmusic.music.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import cn.ltysyn.inmusic.utils.NginxUtil;
import lombok.Data;

@Data
@Entity(name = "t_album")
public class Album implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8473540183217056433L;

	@Id
	@GeneratedValue(generator = "id")
	@GenericGenerator(name = "id", strategy = "assigned")
	private Long albumId;
	
	@Column(length = 500)
	private String albumName;
	
	@Column(columnDefinition = "INT(3) default 0")
	private int size;
	 
	@Column(length = 500)
	private String picUrl;
	
	private Date publishTime;
	
	private String commentThreadId;
	
	private String description;;
	
	private String tags;
	
	private String company;
	
	private Integer aritstId;
	
	public String getPicUrl() {
		return NginxUtil.NGINX_URL + this.picUrl;
	}
}
