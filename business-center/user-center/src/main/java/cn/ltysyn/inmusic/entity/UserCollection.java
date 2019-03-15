package cn.ltysyn.inmusic.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Entity(name = "t_user_collection")
@Data
@EntityListeners(AuditingEntityListener.class)
@ApiModel(value = "用户收藏列表")
public class UserCollection implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9040759972720984995L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
	private Long userId;
	
	@Column
	private Long songId;

}
