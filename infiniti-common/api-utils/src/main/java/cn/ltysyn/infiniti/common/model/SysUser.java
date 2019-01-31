package cn.ltysyn.infiniti.common.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity(name = "sys_user")
public class SysUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7705101140958318974L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String username;
	
	private String password;
	
	private String nickname;
	
	private String headImgUrl;
	
	private String phone;
	
	private Integer sex;
	
	private Boolean enabled;
	
	private String type;

	private Date createTime;
	
	private Date updateTime;

	@Transient
	private List<SysRole> roles;

	@Transient
	private String roleId;

	@Transient
	private String oldPassword;
	
	@Transient
	private String newPassword;

}
