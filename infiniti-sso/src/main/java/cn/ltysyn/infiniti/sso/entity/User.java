package cn.ltysyn.infiniti.sso.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import cn.ltysyn.infiniti.sso.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity(name = "t_user")
@ApiModel(value = "用户类")
public class User extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4141754363461066532L;
	
	@ApiModelProperty(value = "用户名")
	@Column(unique = true, nullable = false)
	private String username;
	
	@ApiModelProperty(value = "密码")
	private String password;
	
	@ApiModelProperty(value = "昵称")
	private String nickName;

}
