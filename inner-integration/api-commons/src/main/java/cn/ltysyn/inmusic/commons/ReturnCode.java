package cn.ltysyn.inmusic.commons;

public enum ReturnCode {
	
	// 歌手相关
	ARTIST_LIST_GOT(10001, "歌手列表获取成功"),
	
	ARTIST_INFO_GOT(10002, "歌手信息获取成功"),
	
	// 专辑相关
	ALBUM_LIST_GOT(10003, "专辑列表获取成功"),
	
	ALBUM_INFO_GOT(10004, "专辑信息获取成功"),
	
	ALBUMS_IN_ARTIST_GOT(10005, "歌手内专辑数据获取成功"),
	
	// 音乐相关
	SONG_LIST_GOT(10006, "音乐列表获取成功"),
	
	SONG_INFO_GOT(10007, "音乐信息获取成功"),
	
	SONGS_IN_ALBUM_GOT(10008, "专辑内音乐数据获取成功"),
	
	// 用户相关
	USER_CREATE_SUCCEED(40001, "用户注册成功"),
	
	USER_REGISTER_ERROR(40002, "用户注册失败，请稍后重试"),
	
	USER_LOGIN_SUCCEED(40003, "用户登录成功"),
	
	USER_LOGIN_FAILED(40004, "用户登录失败，用户名或密码有误"),
	
	USER_PASSWORD_UPDATE_SUCCEED(40005, "用户密码修改成功"),
	
	USER_PASSWORD_UPDATE_FAILED(40006, "用户密码更新失败"),
	
	USER_LIST_GOT(40007, "用户列表获取成功"),
	
	// 收藏服务相关
	USER_COLLECTS_GOT(50001, "用户收藏列表获取成功");
	
	private int code;
	
	private String message;
	
	private ReturnCode(int code, String message) {
		// TODO Auto-generated constructor stub
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
