/**
 * 
 */
package com.@__company__@.@__scope__@.@__template__@.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import com.@__company__@.@__scope__@.@__template__@.facade.DemoFacade;
import com.@__company__@.@__scope__@.@__template__@.model.DemoModel;
import com.@__company__@.@__scope__@.@__template__@.service.DemoService;
import com.github.biticcf.mountain.core.common.result.CallResult;
import com.github.biticcf.mountain.core.common.result.ReturnResult;
import com.github.biticcf.mountain.core.common.result.reactor.ResultExecutor;
import com.github.biticcf.mountain.core.common.result.reactor.ResultPaginationExecutor;
import com.github.biticcf.mountain.core.common.util.PaginationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import reactor.core.publisher.Mono;

/**
 * 
 * @Author: DanielCao
 * @Date:   2017年5月8日
 * @Time:   下午2:54:19
 *
 */
@Api(value = "测试服务接口", description = "测试信息")
@Validated
@RestController
public class DemoController extends BaseController implements DemoFacade {
	@Autowired
	private DemoService demoService;
	
	@ApiOperation(value = "新建测试信息",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			httpMethod = "POST", 
			notes = "新建测试信息")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "成功")
	})
	@Override
	public Mono<ReturnResult<DemoModel>> insertDemo(
		@ApiParam(name = "demoModel", value = "待录入demo信息", required = true) @Valid final DemoModel demoModel) throws Throwable {
		Map<String, Object> _paramValueMap = new HashMap<>();
		_paramValueMap.put("demoModel", demoModel);
		
		return new ResultExecutor<DemoModel, DemoModel>() {
			@Override
			public CallResult<DemoModel> execute() {
				return demoService.insertDemo(demoModel);
			}
		}.processResult("DemoController.insertDemo", "POST", _paramValueMap, DemoModel.class);
	}
	
	@ApiOperation(value = "查询测试信息",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			httpMethod = "GET", 
			notes = "查询测试信息")
		@ApiResponses(value = {
			@ApiResponse(code = 200, message = "成功")
	})
	@ApiImplicitParams(value = {
		@ApiImplicitParam (paramType = "path", name = "id", value = "id值", required = true,  defaultValue = "1", dataType = "Long")
	})
	@Override
	public Mono<ReturnResult<DemoModel>> queryById(Long id, String t) throws Throwable {
		Map<String, Object> _paramValueMap = new HashMap<>();
		_paramValueMap.put("id", id);
		
		return new ResultExecutor<DemoModel, DemoModel>() {
			@Override
			public CallResult<DemoModel> execute() {
				return demoService.queryById(id);
			}
		}.processResult("DemoController.queryById", "GET", _paramValueMap, DemoModel.class);
	}
	
	@ApiOperation(value = "查询列表信息",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			httpMethod = "GET", 
			notes = "查询列表信")
		@ApiResponses(value = {
			@ApiResponse(code = 200, message = "成功")
	})
	@ApiImplicitParams(value = {
		@ApiImplicitParam (paramType = "query", name = "p", value = "分页信息-页码", required = true,  defaultValue = "1", dataType = "int"),
		@ApiImplicitParam (paramType = "query", name = "ps", value = "分页信息-每页数据", required = true,  defaultValue = "20", dataType = "int")
	})
	@Override
	public Mono<ReturnResult<List<DemoModel>>> queryList(int p, int ps) throws Throwable {
		Map<String, Object> _paramValueMap = new HashMap<>();
		_paramValueMap.put("p", p);
		_paramValueMap.put("ps", ps);
		
		return new ResultPaginationExecutor<DemoModel, DemoModel>() {
			@Override
			public CallResult<PaginationSupport<DemoModel>> execute() {
				return demoService.queryList(p, ps);
			}
		}.processResult("DemoController.queryList", "GET", _paramValueMap, DemoModel.class);
	}
}
