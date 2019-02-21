/**
 * 
 */
package com.@__company__@.@__scope__@.@__template__@.facade;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beyonds.phoenix.mountain.core.common.result.ReturnResult;
import com.@__company__@.@__scope__@.@__template__@.model.DemoModel;

import reactor.core.publisher.Mono;

/**
 * @Author: DanielCao
 * @Date:   2018年5月20日
 * @Time:   下午8:33:39
 *
 */
@RequestMapping(value = "/@__scope__@/@__template__@/v1")
public interface DemoFacade {
	/**
	 * 保存数据
	 * @param demoModel 数据记录
	 * @return 保存结果
	 */
	@RequestMapping(value = {"/demo"}, 
			        method = {RequestMethod.POST}, 
			        produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	Mono<ReturnResult<DemoModel>> insertDemo(@RequestBody @Valid DemoModel demoModel) throws Throwable;
	
	/**
	 * 根据id查询结果
	 * @param id id值
	 * @param t 参数
	 * @return 返回查询到的结果
	 */
	@RequestMapping(value = {"/demo/{id}"}, 
	        method = {RequestMethod.GET}, 
	        produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	Mono<ReturnResult<DemoModel>> queryById(
			@PathVariable(value = "id", required = true) Long id,
			@RequestParam(value = "t", required = true) String t) throws Throwable;
    
    /**
	 * 分页查询结果
	 * @param p 分页参数
	 * @param ps 分页参数
	 * @return 结果集
	 */
	@RequestMapping(value = {"/demos"}, 
	        method = {RequestMethod.GET}, 
	        produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	Mono<ReturnResult<List<DemoModel>>> queryList(
			@RequestParam(value = "p", required = true) int p,
			@RequestParam(value = "ps", required = true) int ps) throws Throwable;
}
