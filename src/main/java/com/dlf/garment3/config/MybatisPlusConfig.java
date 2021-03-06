package com.dlf.garment3.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by dlf on 2018/3/10 0010.
 * Email 1429264916@qq.com
 */
@Configuration
@MapperScan("com.dlf.garment2.mapper")
public class MybatisPlusConfig {
    /*
    * 分页插件，自动识别数据库类型
    * 多租户，请参考官网【插件扩展】
    */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
