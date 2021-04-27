package me.bk.memberservice.common.exception;

import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import me.bk.memberservice.common.dto.ErrorResponse;
import me.bk.memberservice.common.exception.impl.CommonMethodArgumentNotValidException;

/**
 * @author : byungkyu
 * @date : 2021/04/26
 * @description :
 **/
@RestControllerAdvice
public class CommonExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException exception) {
		CommonMethodArgumentNotValidException commonMethodArgumentNotValidException = new CommonMethodArgumentNotValidException(exception);
		return ResponseEntity.badRequest().body(new ErrorResponse(commonMethodArgumentNotValidException));
	}

}
