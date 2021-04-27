package me.bk.memberservice.common.exception.impl;

import java.util.stream.Collectors;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

import me.bk.memberservice.common.exception.CommonException;

/**
 * @author : byungkyu
 * @date : 2021/04/26
 * @description :
 **/
public class CommonMethodArgumentNotValidException extends RuntimeException implements CommonException {
	public static final String ERROR_CODE = "METHOD_ARGUMENT_NOT_VALID_EXCEPTION";

	private String errorMessage = "입력값이 존재하지 않습니다.";

	public CommonMethodArgumentNotValidException() {
		super();
	}

	public CommonMethodArgumentNotValidException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public CommonMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {

		BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();
		String errorMessage = bindingResult.getFieldErrors().stream()
			.map(fieldError -> {
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append("입력값 ");
				stringBuilder.append(fieldError.getField());
				stringBuilder.append(" 이(가) 올바르지 않습니다.");
				stringBuilder.append("\nCause: " + fieldError.getField());
				stringBuilder.append("\nMessage: " + fieldError.getDefaultMessage());
				return stringBuilder;
			})
			.collect(Collectors.joining("\n"));
		this.errorMessage = errorMessage;

	}

	@Override
	public String getErrorCode() {
		return ERROR_CODE;
	}

	@Override
	public String getErrorMessage() {
		return errorMessage;
	}
}
