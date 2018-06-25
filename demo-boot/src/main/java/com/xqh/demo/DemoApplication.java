package com.xqh.demo;

import com.xqh.demo.shiro.MyRealm;
import org.apache.shiro.realm.Realm;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@MapperScan(
		basePackages = {"com.xqh.demo.dao"}
)
@ImportResource({
		"classpath:dubbo-base.xml",
		"classpath:dubbo-provider.xml",
		"classpath:dubbo-consumer.xml"
})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
