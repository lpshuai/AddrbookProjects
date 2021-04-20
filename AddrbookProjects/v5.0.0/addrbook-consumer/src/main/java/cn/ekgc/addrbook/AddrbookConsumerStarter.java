package cn.ekgc.addrbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Addrbook Consumer 启动类
 * @version 5.0.0
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class AddrbookConsumerStarter {
	public static void main(String[] args) {
		SpringApplication.run(AddrbookConsumerStarter.class,args);
	}
}
