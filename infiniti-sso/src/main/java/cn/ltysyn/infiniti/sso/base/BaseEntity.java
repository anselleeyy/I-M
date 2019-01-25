package cn.ltysyn.infiniti.sso.base;

import java.io.Serializable;

import javax.persistence.Id;

public class BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7534984418186718513L;
	
	@Id
	private String Id;

}
