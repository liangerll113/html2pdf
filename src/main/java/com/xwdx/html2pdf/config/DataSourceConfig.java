package com.xwdx.html2pdf.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author kongmingliang
 * @date 2021-12-17 18:17
 **/
@MapperScan("com.xwdx.html2pdf.mapper")
@Configuration
public class DataSourceConfig {
}
