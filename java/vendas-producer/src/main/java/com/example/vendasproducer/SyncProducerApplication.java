package com.example.vendasproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisReactiveAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication( exclude = { RedisReactiveAutoConfiguration.class } )
@EnableAsync
public class SyncProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SyncProducerApplication.class, args);
	}

}