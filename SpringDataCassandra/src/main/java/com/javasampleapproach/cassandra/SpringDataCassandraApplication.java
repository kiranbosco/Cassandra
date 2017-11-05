package com.javasampleapproach.cassandra;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableAutoConfiguration
public class SpringDataCassandraApplication{
	public static void main(String[] args) {
		SpringApplication.run(SpringDataCassandraApplication.class, args);
	}


}