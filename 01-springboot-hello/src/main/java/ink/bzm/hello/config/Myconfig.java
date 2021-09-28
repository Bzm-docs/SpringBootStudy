package ink.bzm.hello.config;

import ink.bzm.hello.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: buzhengmiao    docs.bzm.ink
 * @time: 2021/9/16 下午4:16
 */
@Configuration(proxyBeanMethods = true)	//默认true（单实例）
public class Myconfig {
	@Bean
	public HelloService helloService() {
		return new HelloService();
	}
}
