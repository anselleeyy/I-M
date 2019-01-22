package cn.ltysyn.infiniti.music.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

import cn.ltysyn.infiniti.common.utils.Constant;
import lombok.Data;

@Data
@Entity(name = "t_song")
public class Song implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7453970643166232460L;

	@Id
	@GeneratedValue(generator = "id")
	@GenericGenerator(name = "id", strategy = "assigned")
	private long songId;
	
	@Column(length = 40)
	private String songName;
	
	private String mp3Url;
	
	@Column(length = 5000)
	private String lyric;
	
	private long albumId;
	
	public String getMp3Url() {
		return Constant.NGINX_URL + this.mp3Url;
	}
}