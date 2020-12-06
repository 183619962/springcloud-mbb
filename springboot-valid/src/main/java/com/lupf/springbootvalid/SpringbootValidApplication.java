package com.lupf.springbootvalid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// 小细节 如果是多模块；这里需要指定一下扫描的路径 否则可能导致jar包中的包无法导入
@SpringBootApplication(scanBasePackages = "com.lupf")
@EnableAspectJAutoProxy(exposeProxy = true)
public class SpringbootValidApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootValidApplication.class, args);
	}

}
