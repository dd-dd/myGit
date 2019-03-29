package com.bonc.demoweb;

import javax.servlet.MultipartConfigElement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
@ServletComponentScan
@MapperScan("com.bonc.demoweb.dao")
@EnableScheduling
@SpringBootApplication
public class DemowebApplication extends SpringBootServletInitializer{

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {  
        return application.sources(DemowebApplication.class);  
    } 
	
	public static void main(String[] args) {
		SpringApplication.run(DemowebApplication.class, args);
	}
	
	 @Bean  
	    public MultipartConfigElement multipartConfigElement() {  
	        MultipartConfigFactory factory = new MultipartConfigFactory();  
	        //单个文件最大  
	        factory.setMaxFileSize("102400KB"); //KB,MB  
	        /// 设置总上传数据总大小  
	        factory.setMaxRequestSize("1024000KB");  
	        return factory.createMultipartConfig();  
	    }  
}
