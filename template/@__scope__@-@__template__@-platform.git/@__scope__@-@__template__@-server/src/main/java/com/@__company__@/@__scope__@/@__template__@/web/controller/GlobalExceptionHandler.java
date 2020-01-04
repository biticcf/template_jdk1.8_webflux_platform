/**
 * 
 */
package com.@__company__@.@__scope__@.@__template__@.web.controller;

import java.io.IOException;

import javax.validation.ConstraintViolationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.server.ResponseStatusException;

import com.@__company__@.@__scope__@.@__template__@.model.enums.ResultEnum;
import com.github.biticcf.mountain.core.common.lang.WdRuntimeException;
import com.github.biticcf.mountain.core.common.result.ReturnResult;

import reactor.core.publisher.Mono;

/**
 * @Author: DanielCao
 * @Date:   2017年11月14日
 * @Time:   上午11:18:09
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	private static Log logger = LogFactory.getLog("WEB.LOG");
	
	/**
	 * NullPointerException异常处理
	 * @param ex NullPointerException
	 * @return 返回结果
	 */
	@ExceptionHandler(value = NullPointerException.class)
	@ResponseStatus(code = HttpStatus.OK)
	public Mono<ReturnResult<Object>> nullPointerExceptionHandler(NullPointerException ex) {
		ResultEnum resultEnu = ResultEnum.SYS_ERROR;
		
		String errorMsg = "NullPointerException Error!";
		
		return exceptionHandler(resultEnu, errorMsg, ex, null);
	}
	
	/**
	 * ClassCastException异常处理
	 * @param ex ClassCastException
	 * @return 返回结果
	 */
	@ExceptionHandler(value = ClassCastException.class)
	@ResponseStatus(code = HttpStatus.OK)
	public Mono<ReturnResult<Object>> classCastExceptionHandler(ClassCastException ex) {
		ResultEnum resultEnu = ResultEnum.SYS_ERROR;
		
		String errorMsg = "ClassCastException Error!";
		
		return exceptionHandler(resultEnu, errorMsg, ex, null);
	}
	
	/**
	 * IOException异常处理
	 * @param ex IOException
	 * @return 返回结果
	 */
	@ExceptionHandler(value = IOException.class)
	@ResponseStatus(code = HttpStatus.OK)
	public Mono<ReturnResult<Object>> ioExceptionHandler(IOException ex) {
		ResultEnum resultEnu = ResultEnum.SYS_ERROR;
		
		String errorMsg = "IOException Error!";
		
		return exceptionHandler(resultEnu, errorMsg, ex, null);
	}
	
	/**
	 * NoSuchMethodException异常处理
	 * @param ex NoSuchMethodException
	 * @return 返回结果
	 */
	@ExceptionHandler(value = NoSuchMethodException.class)
	@ResponseStatus(code = HttpStatus.OK)
	public Mono<ReturnResult<Object>> noSuchMethodExceptionHandler(NoSuchMethodException ex) {
		ResultEnum resultEnu = ResultEnum.SYS_ERROR;
		
		String errorMsg = "NoSuchMethodException Error!";
		
		return exceptionHandler(resultEnu, errorMsg, ex, null);
	}
	
	/**
	 * IndexOutOfBoundsException异常处理
	 * @param ex IndexOutOfBoundsException
	 * @return 返回结果
	 */
	@ExceptionHandler(value = IndexOutOfBoundsException.class)
	@ResponseStatus(code = HttpStatus.OK)
	public Mono<ReturnResult<Object>> indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
		ResultEnum resultEnu = ResultEnum.SYS_ERROR;
		
		String errorMsg = "IndexOutOfBoundsException Error!";
		
		return exceptionHandler(resultEnu, errorMsg, ex, null);
	}
	
	/**
	 * HttpMessageNotReadableException(404)异常处理
	 * @param ex HttpMessageNotReadableException
	 * @return 返回结果
	 */
	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	@ResponseStatus(code = HttpStatus.OK)
	public Mono<ReturnResult<Object>> httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException ex) {
		ResultEnum resultEnu = ResultEnum.PATH_NOT_FOUND;
		
		String errorMsg = "HttpMessageNotReadableException Error!";
		
		return exceptionHandler(resultEnu, errorMsg, ex, null);
	}
	
	/**
	 * ResponseStatusException(404)异常处理
	 * @param ex ResponseStatusException
	 * @return 返回结果
	 */
	@ExceptionHandler(value = ResponseStatusException.class)
	@ResponseStatus(code = HttpStatus.OK)
	public Mono<ReturnResult<Object>> noHandlerFoundExceptionHandler(ResponseStatusException ex) {
		ResultEnum resultEnu = ResultEnum.PATH_NOT_FOUND;
		
		String errorMsg = "ResponseStatusException Error!";
		
		return exceptionHandler(resultEnu, errorMsg, ex, ex.getCause());
	}
	
	/**
	 * HttpRequestMethodNotSupportedException(405)异常处理
	 * @param ex HttpRequestMethodNotSupportedException
	 * @return 返回结果
	 */
	@ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
	@ResponseStatus(code = HttpStatus.OK)
	public Mono<ReturnResult<Object>> httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException ex) {
		ResultEnum resultEnu = ResultEnum.PARAM_ERROR;
		
		String errorMsg = "HttpRequestMethodNotSupportedException Error!";
		
		return exceptionHandler(resultEnu, errorMsg, ex, ex.getMethod());
	}
	
	/**
	 * HttpMediaTypeNotAcceptableException(406)异常处理
	 * @param ex HttpMediaTypeNotAcceptableException
	 * @return 返回结果
	 */
	@ExceptionHandler(value = HttpMediaTypeNotAcceptableException.class)
	@ResponseStatus(code = HttpStatus.OK)
	public Mono<ReturnResult<Object>> httpMediaTypeNotAcceptableExceptionHandler(HttpMediaTypeNotAcceptableException ex) {
		ResultEnum resultEnu = ResultEnum.PARAM_ERROR;
		
		String errorMsg = "HttpMediaTypeNotAcceptableException Error!";
		
		return exceptionHandler(resultEnu, errorMsg, ex, ex.getSupportedMediaTypes());
	}
	
	/**
	 * MethodArgumentNotValidException异常处理
	 * @param ex MethodArgumentNotValidException
	 * @return 返回结果
	 */
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.OK)
	public Mono<ReturnResult<Object>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
		ResultEnum resultEnu = ResultEnum.PARAM_ERROR;
		
		String errorMsg = "MethodArgumentNotValidException Error!";
		
		return exceptionHandler(resultEnu, errorMsg, ex, ex.getParameter());
	}
	
	/**
	 * ConstraintViolationException异常处理
	 * @param ex ConstraintViolationException
	 * @return 返回结果
	 */
	@ExceptionHandler(value = ConstraintViolationException.class)
	@ResponseStatus(code = HttpStatus.OK)
	public Mono<ReturnResult<Object>> constraintViolationExceptionHandler(ConstraintViolationException ex) {
		ResultEnum resultEnu = ResultEnum.PARAM_ERROR;
		
		String errorMsg = "ConstraintViolationException Error!";
		
		return exceptionHandler(resultEnu, errorMsg, ex, ex.getConstraintViolations());
	}
	
	/**
	 * HttpClientErrorException异常处理
	 * @param ex HttpClientErrorException
	 * @return 返回结果
	 */
	@ExceptionHandler(value = HttpClientErrorException.class)
	public Mono<ReturnResult<Object>> httpClientErrorExceptionHandler(HttpClientErrorException ex) {
		HttpStatus statusCode = ex.getStatusCode();
		if (statusCode == null) {
			statusCode = HttpStatus.BAD_REQUEST;
		}
		String errorMsg = "HttpClientErrorException Error!";
		
		return exceptionHandler(statusCode.value(), statusCode.getReasonPhrase() + "[" + ex.getMessage() + "]", ex, errorMsg);
	}
	
	/**
	 * HttpServerErrorException异常处理
	 * @param ex HttpServerErrorException
	 * @return 返回结果
	 */
	@ExceptionHandler(value = HttpServerErrorException.class)
	public Mono<ReturnResult<Object>> httpServerErrorExceptionHandler(HttpServerErrorException ex) {
		HttpStatus statusCode = ex.getStatusCode();
		if (statusCode == null) {
			statusCode = HttpStatus.SERVICE_UNAVAILABLE;
		}
		String errorMsg = "HttpServerErrorException Error!";
		
		return exceptionHandler(statusCode.value(), statusCode.getReasonPhrase() + "[" + ex.getMessage() + "]", ex, errorMsg);
	}
	
	/**
	 * WdRuntimeException异常处理
	 * @param ex WdRuntimeException
	 * @return 返回结果
	 */
	@ExceptionHandler(value = WdRuntimeException.class)
	@ResponseStatus(code = HttpStatus.OK)
	public Mono<ReturnResult<Object>> wdRuntimeExceptionHandler(WdRuntimeException ex) {
		ResultEnum resultEnu = ResultEnum.FAILURE;
		
		String errorMsg = "WdRuntimeException Error!";
		
		return exceptionHandler(resultEnu, errorMsg, ex, ex.getDesc());
	}
	
	/**
	 * RuntimeException异常处理
	 * @param ex RuntimeException
	 * @return 返回结果
	 */
	@ExceptionHandler(value = RuntimeException.class)
	@ResponseStatus(code = HttpStatus.OK)
	public Mono<ReturnResult<Object>> runtimeExceptionHandler(RuntimeException ex) {
		ResultEnum resultEnu = ResultEnum.SYS_ERROR;
		
		String errorMsg = "RuntimeException Error!";
		
		return exceptionHandler(resultEnu, errorMsg, ex, null);
	}
	
	/**
	 * Exception异常处理
	 * @param ex Exception
	 * @return 返回结果
	 */
	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(code = HttpStatus.OK)
	public Mono<ReturnResult<Object>> otherExceptionHandler(Exception ex) {
		ResultEnum resultEnu = ResultEnum.FAILURE;
		
		String errorMsg = "Exception Error!";
		
		return exceptionHandler(resultEnu, errorMsg, ex, null);
	}
	
	/**
	 * Throwable异常处理
	 * @param ex Throwable
	 * @return 返回结果
	 */
	@ExceptionHandler(value = Throwable.class)
	@ResponseStatus(code = HttpStatus.OK)
	public Mono<ReturnResult<Object>> otherThrowableHandler(Throwable ex) {
		ResultEnum resultEnu = ResultEnum.FAILURE;
		
		String errorMsg = "Throwable Error!";
		
		return exceptionHandler(resultEnu, errorMsg, ex, null);
	}
	
	/**
	 * +统一异常处理
	 * @param resultEnu
	 * @return
	 */
	private Mono<ReturnResult<Object>> exceptionHandler(ResultEnum resultEnu, String errorMsg, Throwable th, Object entry) {
		writeErrorLog(errorMsg, th);
		
		ReturnResult<Object> result = new ReturnResult<Object>(resultEnu.getCode(), resultEnu.getDesc(), entry);
		
		return Mono.just(result);
	}
	/**
	 * +统一异常处理
	 * @param errorCode
	 * @param errorMsg
	 * @param th
	 * @param entry
	 * 
	 * @return
	 */
	private Mono<ReturnResult<Object>> exceptionHandler(int errorCode, String errorMsg, Throwable th, Object entry) {
		writeErrorLog(errorMsg, th);
		
		ReturnResult<Object> result = new ReturnResult<Object>(errorCode, errorMsg, entry);
		
		return Mono.just(result);
	}
	
	/**
	 * 错误日志输出
	 * @param message 日志内容
	 * @param t 异常
	 */
	public void writeErrorLog(final String message, final Throwable t) {
		if (logger.isErrorEnabled()) {
			logger.error(message, t);
		}
	}

	/**
	 * 错误日志输出
	 * @param message 日志内容
	 */
	public void writeErrorLog(final String message) {
		if (logger.isErrorEnabled()) {
			logger.error(message);
		}
	}
}
