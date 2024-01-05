package com.example.practise_Alisher;

import com.example.practise_Alisher.dbRepository.TeachersRepository;
import com.example.practise_Alisher.dbService.EventsService;
import com.example.practise_Alisher.dbService.StudentsService;
import com.example.practise_Alisher.dbService.TeachersService;
import com.example.practise_Alisher.exec_sch.AnotherMethod;
import com.example.practise_Alisher.exec_sch.Schedule;
import com.example.practise_Alisher.exec_sch.SmthMethod;
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
		ConfigurableApplicationContext ctx = SpringApplication.run(Main.class, args);

		StudentsService studentsService = ctx.getBean("studentsService", StudentsService.class);
		TeachersService teachersService = ctx.getBean("teachersService", TeachersService.class);
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		new Thread(new SmthMethod(studentsService)).start();
		new Thread(String.valueOf(new AnotherMethod(teachersService))).start();
		Schedule schedule = new Schedule(studentsService, teachersService);
		schedule.fixedDelayTask();
		schedule.fixedRateTask();
		schedule.cronExpressionMethod();
	}
}


