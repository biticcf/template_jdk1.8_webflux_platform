/**
 * 
 */
package com.@__company__@.@__scope__@.@__template__@.domain.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.@__company__@.@__scope__@.@__template__@.domain.feign.config.FeignConfig;
import com.@__company__@.@__scope__@.@__template__@.domain.feign.fallback.CategoryFeignClientFallback;

/**
 * @Author: DanielCao
 * @Date:   2017年6月28日
 * @Time:   下午11:50:11
 *
 */
@FeignClient(name = "categoryFeignClient",
		     url = "http://127.0.0.1:12222", 
             fallback = CategoryFeignClientFallback.class,
             configuration = {FeignConfig.class})
public interface CategoryFeignClient {
	/**
	 * 第三方业务接口
	 * @param categoryIds 参数
	 * @return 结果
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/v1/bp/categorys/multi")
	String getCategorys(@RequestParam("categoryIds") String categoryIds);
}
