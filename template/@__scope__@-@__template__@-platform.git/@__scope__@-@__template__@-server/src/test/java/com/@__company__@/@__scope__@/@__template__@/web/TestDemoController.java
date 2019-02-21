/**
 * 
 */
package com.@__company__@.@__scope__@.@__template__@.web;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.http.MediaType;

/**
 * @Author: DanielCao
 * @Date:   2017年5月15日
 * @Time:   上午8:28:34
 *
 */
public class TestDemoController extends AbstTestController {
	
	/**
	 * 测试根据id查询接口
	 */
	@Test
	public void testDemoQueryById() {
		boolean testFlag = true;
		if (!testFlag) {
			return;
		}
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("a", "aa");
		params.put("id", "1");
		params.put("t", "1");
		
		String uri = "/@__scope__@/@__template__@/v1/demo/{id}?a={a}&t={t}";
		webTestClient
			.get().uri(uri, params)
			.headers(headers -> {
				MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
				
				headers.setContentType(type);
				headers.add("Accept", MediaType.APPLICATION_JSON.toString());
			})
			.acceptCharset(Charset.forName("UTF-8"))
			.accept(MediaType.APPLICATION_JSON_UTF8)
			.exchange()
			.expectStatus().isOk()
			.expectBody(String.class)
			.consumeWith(entry -> {
				logger.info(entry.getResponseBody());
			});
	}
}
