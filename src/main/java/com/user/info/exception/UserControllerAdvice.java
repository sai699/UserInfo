package com.user.info.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import com.user.info.util.ApplicationConstants;
import com.user.info.vo.ErrorVO;

@RestControllerAdvice
public class UserControllerAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorVO methodArgumentNotValidException() {
		ErrorVO errorVO = new ErrorVO();
		errorVO.setStatusCode(ApplicationConstants.BAD_REQUEST_CODE);
		errorVO.setStatusDesc(ApplicationConstants.BAD_REQUEST_DESC);
		return errorVO;
	}

	@ExceptionHandler(UserException.class)
	public ErrorVO globalExceptionhandle() {
		ErrorVO errorVO = new ErrorVO();
		errorVO.setStatusCode(ApplicationConstants.INTERNAL_SERVER_ERROR_CODE);
		errorVO.setStatusDesc(ApplicationConstants.INTERNAL_SERVER_ERROR_DESC);
		return errorVO;

	}

}
