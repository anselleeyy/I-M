package cn.ltysyn.inmusic.utils;

import java.util.UUID;

/**
 * 抽离 Redis Token 的一些参数和方法
 * @author liyaoyu
 *
 */
public class TokenUtil {
	
	public static final int TOKEN_EXPIRE_SEC = 1000;
	
	public static final int TOKEN_EXPIRE_MIN = 30;
	
	public static final int TOKEN_EXPIRE_HOUR = 1;
	
	public static String generateToken() {
		return UUID.randomUUID().toString().replace("-", "");
	}

}
