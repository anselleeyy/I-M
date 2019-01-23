package cn.ltysyn.infiniti.music.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
import lombok.Data;

@Data
@Entity(name = "t_artist")
public class Artist implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3654251917402225590L;
	
	@Id
	@GeneratedValue(generator = "id")
	@GenericGenerator(name = "id", strategy = "assigned")
	private Integer artistId;

	@Column(length = 40)
	private String artistName;
	
	private String picUrl;

}
