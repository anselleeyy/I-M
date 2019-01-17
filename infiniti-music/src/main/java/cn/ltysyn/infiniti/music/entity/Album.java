package cn.ltysyn.infiniti.music.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import cn.ltysyn.infiniti.common.utils.Constant;
import lombok.Data;

@Data
@Entity(name = "t_album")
public class Album implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8473540183217056433L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long albumId;
	
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
	
	private int aritstId;
	
	public String getPicUrl() {
		return Constant.NGINX_URL + this.picUrl;
	}
}
