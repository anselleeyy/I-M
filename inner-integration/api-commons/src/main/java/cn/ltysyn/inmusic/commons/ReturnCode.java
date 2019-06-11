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
	
	SONG_ADD_SUCCEED(20001, "音乐添加成功"),
	
	SONG_ADD_FAILED(20002, "音乐添加失败"),
	
	SONG_UPDATE_SUCCEED(20003, "音乐信息修改成功"),
	
	SONG_UPDATE_FAILED(20004, "音乐信息修改失败"),
	
	SONG_DELETE_SUCCEED(20005, "音乐信息删除成功"),
	
	SONG_DELETE_FAILED(20006, "音乐信息删除失败"),
	
	ALBUM_ADD_SUCCEED(20007, "专辑添加成功"),
	
	ALBUM_ADD_FAILED(20008, "专辑添加失败"),
	
	ALBUM_UPDATE_SUCCEED(20009, "专辑信息修改成功"),
	
	ALBUM_UPDATE_FAILED(20010, "专辑信息修改失败"),
	
	ALBUM_DELETE_SUCCEED(20011, "专辑信息删除成功"),
	
	ALBUM_DELETE_FAILED(20012, "专辑信息删除失败"),
	
	ARTIST_ADD_SUCCEED(20013, "歌手添加成功"),
	
	ARTIST_ADD_FAILED(20014, "歌手添加失败"),
	
	ARTIST_UPDATE_SUCCEED(20015, "歌手信息修改成功"),
	
	ARTIST_UPDATE_FAILED(20016, "歌手信息修改失败"),
	
	ARTIST_DELETE_SUCCEED(20017, "歌手信息删除成功"),
	
	ARTIST_DELETE_FAILED(20018, "歌手信息删除失败"),
	
	// 用户相关
	USER_CREATE_SUCCEED(40001, "用户注册成功"),
	
	USER_REGISTER_ERROR(40002, "用户注册失败，请稍后重试"),
	
	USER_LOGIN_SUCCEED(40003, "用户登录成功"),
	
	USER_LOGIN_FAILED(40004, "用户登录失败，用户名或密码有误"),
	
	USER_PASSWORD_UPDATE_SUCCEED(40005, "用户密码修改成功"),
	
	USER_PASSWORD_UPDATE_FAILED(40006, "用户密码更新失败"),
	
	USER_LIST_GOT(40007, "用户列表获取成功"),
	
	// 收藏服务相关
	USER_COLLECTS_GOT(50001, "用户收藏列表获取成功"),
	
	USER_COLLECT_SUCCEED(50002, "用户收藏成功"),
	
	USER_COLLECT_FAILED(50003, "用户收藏失败"),
	
	USER_DEL_COLLECT_SUCCEED(50004, "用户删除收藏成功"),
	
	USER_DEL_COLLECT_FAILED(50005, "用户删除收藏失败"),
	
	// 管理员相关
	REDIS_KEY_GOT(60001, "redis 所有 key 获取成功"),
	
	REDIS_MEMORY_GOT(60002, "redis 内存信息获取成功"),
	
	REDIS_INFO_GOT(60003, "redis 信息获取成功"),
	
	ADMIN_LOGIN_SUCCEED(60004, "管理员登录成功"),
	
	ADMIN_LOGIN_AUTH_FAILED(60005, "权限不足"),
    
	ADMIN_LOGIN_FAILED(60006, "用户登录失败，用户名或密码有误"),;
	
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
