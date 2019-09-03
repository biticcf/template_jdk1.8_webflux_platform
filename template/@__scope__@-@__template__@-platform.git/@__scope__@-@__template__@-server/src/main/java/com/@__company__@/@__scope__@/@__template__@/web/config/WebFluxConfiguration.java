/**
 * 
 */
package com.@__company__@.@__scope__@.@__template__@.web.config;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.result.view.ViewResolver;

import com.github.biticcf.mountain.core.common.service.StringDateConverter;
import com.@__company__@.@__scope__@.@__template__@.web.controller.DefaultErrorHandler;

/**
 * @Author: DanielCao
 * @Date:   2017年5月11日
 * @Time:   下午3:35:28
 *
 */
@Configuration
@Import({WebFluxAutoConfiguration.class})
@ComponentScan(
        value = "com.@__company__@.@__scope__@.@__template__@.web",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)
        })
public class WebFluxConfiguration implements WebFluxConfigurer {
	@Autowired
	private ServerProperties serverProperties;
	@Autowired
	private ResourceProperties resourceProperties;
	@Autowired
	private ApplicationContext applicationContext;
	@Autowired
	private ObjectProvider<ViewResolver> viewResolversProvider;
	@Autowired
	private ServerCodecConfigurer serverCodecConfigurer;
	
	@Bean
	@Order(-2)
	public ErrorWebExceptionHandler errorWebExceptionHandler() {
		ErrorAttributes errorAttributes = new DefaultErrorAttributes(this.serverProperties.getError().isIncludeException());
		DefaultErrorHandler exceptionHandler = new DefaultErrorHandler(
				errorAttributes, this.resourceProperties,
				this.serverProperties.getError(), this.applicationContext);
		
		List<ViewResolver> viewResolvers = viewResolversProvider.orderedStream().collect(Collectors.toList());
		exceptionHandler.setViewResolvers(viewResolvers);
		exceptionHandler.setMessageWriters(this.serverCodecConfigurer.getWriters());
		exceptionHandler.setMessageReaders(this.serverCodecConfigurer.getReaders());
		
		return exceptionHandler;
	}
	
	/**
     * +自定义输入的日期格式
     * +覆盖spring.mvc.date-format
     * @return 日期格式转换器
     */
    @Bean
    public StringDateConverter dateConverter() {
    	return new StringDateConverter();
    }
}
