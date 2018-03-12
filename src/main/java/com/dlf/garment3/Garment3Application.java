package com.dlf.garment3;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dlf.garment3.mapper")

public class Garment3Application {

	public static void main(String[] args) {
		SpringApplication.run(Garment3Application.class, args);
	}
}
