/**
 * 
 */
package com.@__company__@.@__scope__@.@__template__@.web.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: DanielCao
 * @Date:   2018年7月25日
 * @Time:   下午7:39:02
 *
 */
@EnableSwagger2
@ConditionalOnProperty(prefix = "swagger2", name = {"enable"}, havingValue = "true", matchIfMissing = false)
@Configuration(proxyBeanMethods = false)
public class Swagger2Configuration implements WebFluxConfigurer {
	
	/**
	 * 定义swagger
	 * @return Docket
	 */
	@Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.@__company__@.@__scope__@.@__template__@"))
                .paths(PathSelectors.any())
                .build();
    }
    
    /**
	 * 定义附加信息
	 * @return ApiInfo
	 */
    private ApiInfo apiInfo() {
    	Contact contact = new Contact("Daniel.Cao", "https://www.jianshu.com/u/36d8b0841835", "19070443@qq.com");
        return new ApiInfoBuilder()
                .title("@__scope__@-@__template__@相关RESTful APIs")
                .description("@__scope__@-@__template__@相关API调用方式及参数详解")
                .termsOfServiceUrl("")
                .contact(contact)
                .version("1.0.0.@__version__@")
                .build();
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	registry.addResourceHandler("/**")
    	        .addResourceLocations("classpath:/static/");
    	registry.addResourceHandler("swagger-ui.html")
    	        .addResourceLocations("classpath:/META-INF/resources/");
    	registry.addResourceHandler("/webjars/**")
    	        .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
