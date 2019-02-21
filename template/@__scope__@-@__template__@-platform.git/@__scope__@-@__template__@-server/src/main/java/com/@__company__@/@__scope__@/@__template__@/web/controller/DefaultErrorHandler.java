/**
 * 
 */
package com.@__company__@.@__scope__@.@__template__@.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.DefaultErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.ServerRequest;

import com.@__company__@.@__scope__@.@__template__@.model.enums.ResultEnum;

/**
 * @Author: Daniel.Cao
 * @Date:   2019年1月6日
 * @Time:   上午11:53:26
 *
 */
public class DefaultErrorHandler extends DefaultErrorWebExceptionHandler {
	
	private final ErrorAttributes errorAttributes;
	
	public DefaultErrorHandler(ErrorAttributes errorAttributes, ResourceProperties resourceProperties,
			ErrorProperties errorProperties, ApplicationContext applicationContext) {
		super(errorAttributes, resourceProperties, errorProperties, applicationContext);
		
		this.errorAttributes = errorAttributes;
	}
	
	/**
	 * Extract the error attributes from the current request, to be used to populate error
	 * views or JSON payloads.
	 * @param request the source request
	 * @param includeStackTrace whether to include the error stacktrace information
	 * @return the error attributes as a Map.
	 */
	@Override
	protected Map<String, Object> getErrorAttributes(ServerRequest request, boolean includeStackTrace) {
		Map<String, Object> result = this.errorAttributes.getErrorAttributes(request, includeStackTrace);
		
		if(result == null || result.isEmpty()) {
			return result;
		}
		
		Map<String, Object> newResult = new HashMap<String, Object>();
		Integer status = (Integer)result.get("status");
		if(status == null) {
			status = ResultEnum.SYS_ERROR.getCode();
		}
		ResultEnum resultEnu = ResultEnum.valueOf(status);
		if(ResultEnum.UNKNOWN.equals(resultEnu)) {
			resultEnu = ResultEnum.SYS_ERROR;
		}
		newResult.put("status", resultEnu.getCode());
		newResult.put("data", result.get("path"));
		newResult.put("message", resultEnu.getDesc());
		newResult.put("meta", null);
		
		return newResult;
	}
	
	/**
	 * Get the HTTP error status information from the error map.
	 * @param errorAttributes the current error information
	 * @return the error HTTP status
	 */
	@Override
	protected HttpStatus getHttpStatus(Map<String, Object> errorAttributes) {
		return HttpStatus.OK;
	}
}
