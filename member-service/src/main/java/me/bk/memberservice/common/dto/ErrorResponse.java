package me.bk.memberservice.common.dto;

import me.bk.memberservice.common.exception.CommonException;

/**
 * @author : byungkyu
 * @date : 2021/04/26
 * @description :
 **/
public class ErrorResponse {
	private String code;
	private String message;

	protected ErrorResponse() {
	}

	public ErrorResponse(CommonException exception) {
		this.code = exception.getErrorCode();
		this.message = exception.getErrorMessage();
	}



	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
