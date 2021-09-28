package ink.bzm.web.conifg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

/**
 * @author: buzhengmiao    https://blogs.bzm.ink/
 * @time: 2021/9/28 下午3:01
 */
@Configuration(proxyBeanMethods = false) // 默认是单实例（true）
public class WebConfig {

	@Bean
	public WebMvcConfigurer webMvcConfigurer(){
		return new WebMvcConfigurer() {
			@Override
			public void configurePathMatch(PathMatchConfigurer configurer) {
				UrlPathHelper urlPathHelper = new UrlPathHelper();
				// 不移除；后面的内容。矩阵变量功能就可以生效
				urlPathHelper.setRemoveSemicolonContent(false);
				configurer.setUrlPathHelper(urlPathHelper);
			}
		};
	}
}
