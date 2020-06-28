package com.hp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.hp.mapper")
public class Day10SpringbootfrontApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day10SpringbootfrontApplication.class, args);
	}

}
