package com.demo.checkpoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class CheckpointApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckpointApplication.class, args);
	}

}
