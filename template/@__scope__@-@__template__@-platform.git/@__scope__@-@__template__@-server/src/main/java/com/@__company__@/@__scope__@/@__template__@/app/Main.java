/**
 * 
 */
package com.@__company__@.@__scope__@.@__template__@.app;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.WebApplicationType;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.github.biticcf.mountain.shackle.EnableShackleTemplates;

/**
 * @Author: DanielCao
 * @Date:   2018年7月2日
 * @Time:   下午5:39:52
 * SpringBoot 主方法
 * @SpringBootApplication相当于
 *     @Configuration+@EnableAutoConfiguration+@ComponentScan
 *
 */
@SpringBootApplication(scanBasePackages = {"com.@__company__@.@__scope__@.@__template__@"}, proxyBeanMethods = false)
@EnableFeignClients(basePackages = {"com.@__company__@.@__scope__@.@__template__@.domain.feign"})
@EnableShackleTemplates(basePackages = {"com.@__company__@.@__scope__@.@__template__@.service"})
@EnableEurekaClient
public class Main {
	/**
	 * 主程序入口(jar格式)
	 * @param args 命令行参数
	 * @throws Exception 执行异常
	 */
	public static void main(String[] args) throws Exception {
		configureApplication(new SpringApplicationBuilder()).run(args);
	}
	
	/**
	 * 定义程序入口
	 * @param builder SpringApplicationBuilder
	 * @return SpringApplicationBuilder
	 */
	private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder) {
        return builder.sources(Main.class).bannerMode(Banner.Mode.CONSOLE).logStartupInfo(true).registerShutdownHook(true).web(WebApplicationType.REACTIVE);
    }
    /**
	 * 不做任何处理
	 */
	public void noop() {
		
	}
}
