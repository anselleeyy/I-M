package cn.ltysyn.inmusic.commons;

public enum ReturnCode {
	
	ARTIST_LIST_GOT(10001, "歌手列表获取成功"),
	
	ARTIST_INFO_GOT(10002, "歌手信息获取成功"),
	
	ALBUM_LIST_GOT(10003, "专辑列表获取成功"),
	
	ALBUM_INFO_GOT(10004, "专辑信息获取成功"),
	
	ALBUMS_IN_ARTIST_GOT(10005, "歌手内专辑数据获取成功"),
	
	SONG_LIST_GOT(10006, "音乐列表获取成功"),
	
	SONG_INFO_GOT(10007, "音乐信息获取成功"),
	
	SONGS_IN_ALBUM_GOT(10008, "专辑内音乐数据获取成功");
	
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
