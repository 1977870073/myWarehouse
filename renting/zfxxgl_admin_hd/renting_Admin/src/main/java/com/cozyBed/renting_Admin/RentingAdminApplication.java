package com.cozyBed.renting_Admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.cozyBed.renting_Admin.mapper")
@SpringBootApplication
public class RentingAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentingAdminApplication.class, args);
	}

}
