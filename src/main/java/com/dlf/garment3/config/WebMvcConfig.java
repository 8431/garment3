/**
 * projectName: fendo-plus-boot
 * fileName: WebMvcConfig.java
 * packageName: com.gzsys.common.config
 * date: 2018-02-01 1:19
 * copyright(c) 2017-2020 xxx公司
 */
package com.dlf.garment3.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * @version: V1.0
 * @author: fendo
 * @className: WebMvcConfig
 * @packageName: com.gzsys.common.config
 * @description: MVC配置
 * @data: 2018-02-01 1:19
 **/
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
    
    /*@Override
	public void addInterceptors(InterceptorRegistry registry) {
		String[] patterns = new String[] { "/api/user/*","/*.html","/swagger-resources/**"};
		registry.addInterceptor(new SysInterceptor())
		                         .addPathPatterns("/**")
		                         .excludePathPatterns(patterns);
		super.addInterceptors(registry);
	}
    */
}
