package com.surichard.myCommon.web.response;

import com.surichard.myCommon.web.result.ResultCode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse<T> {
	
	private String msg;
	
	private String resultCode;
	
	private T data;
	
	public BaseResponse(String resultCode, String msg){
		this.resultCode = resultCode;
		this.msg = msg;
	}
	
	public static <T> BaseResponse<T> succeed(String msg){
		return new BaseResponse<T>(ResultCode.SUCCESS, msg);
	}

	public static <T> BaseResponse<T> succeed(T data){
		BaseResponse<T> response = new BaseResponse<T>();
		response.setData(data);
		response.setResultCode(ResultCode.SUCCESS);
		return response;
	}
	
	public static <T> BaseResponse<T> fail(String msg){
		return new BaseResponse<T>(ResultCode.ERROR, msg);
	}

}
