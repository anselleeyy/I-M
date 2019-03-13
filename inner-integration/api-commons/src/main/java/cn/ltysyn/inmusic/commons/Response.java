package cn.ltysyn.inmusic.commons;

import java.io.Serializable;
import java.sql.Timestamp;

public class Response implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5334785475299942184L;

//	private static final String NULL_JSON_RETURN = "[]";
	
	private int code;
	
	private String message;
	
	private Object result;
	
	private ReturnCode returnCode;
	
	private Timestamp timestamp;

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

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public ReturnCode getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(ReturnCode returnCode) {
		this.returnCode = returnCode;
		this.code = returnCode.getCode();
		this.message = returnCode.getMessage();
	}
	
	public Response() {
		// TODO Auto-generated constructor stub
		this.timestamp = new Timestamp(System.currentTimeMillis());
	}
	
	public Response(ReturnCode returnCode) {
		this.timestamp = new Timestamp(System.currentTimeMillis());
		this.setReturnCode(returnCode);
	}
	
	public Response(ReturnCode returnCode, Object object) {
		this.timestamp = new Timestamp(System.currentTimeMillis());
		this.result = object;
		this.setReturnCode(returnCode);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Response [returnCode=" + returnCode + ", code=" + code + ", message=" + message + ", timestamp=" + timestamp + ", result=" + result + "]";
	}

}
