package com.example.practise_Alisher;

import com.example.practise_Alisher.dbRepository.TeachersRepository;
import com.example.practise_Alisher.dbService.EventsService;
import com.example.practise_Alisher.dbService.StudentsService;
import com.example.practise_Alisher.dbService.TeachersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.Connection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
@Slf4j
public class Main {
	public static void main(String[] args) throws InterruptedException{
		//ConfigurableApplicationContext ctx = SpringApplication.run(Main.class, args);
		SpringApplication.run(Main.class, args);
	}
}


