package cn.ltysyn.infiniti.sso.base;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.ltysyn.infiniti.common.algo.SnowFlakeUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7534984418186718513L;
	
	@Id
	@ApiModelProperty(value = "唯一标识")
	private String id = String.valueOf(SnowFlakeUtil.getFlowIdInstance().nextId());
	
	@CreatedDate
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
	
	@LastModifiedDate
	@ApiModelProperty(value = "更新时间")
	private Date updateTime;

}
