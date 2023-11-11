package com.example.practise_Alisher;

import com.example.practise_Alisher.dbService.EventsService;
import com.example.practise_Alisher.dbService.StudentsService;
import com.example.practise_Alisher.dbService.TeachersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class Main {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Main.class, args);
		/*ServiceD serviceD = ctx.getBean("getServiceD", ServiceD.class);
		serviceD.methodServiceD();
		serviceD.methodExceptionServiceD();*/

		StudentsService studentsService = ctx.getBean("studentsService", StudentsService.class);
		log.info("Students - {}", studentsService.getStudents());
		log.info("Student result after find - {}", studentsService.findStudentById(1));
		TeachersService teachersService = ctx.getBean("teachersService", TeachersService.class);
		log.info("Teachers - {}", teachersService.getTeachers());
		log.info("Teacher result after find - {}", teachersService.findTeacherById(1));
		EventsService eventsService = ctx.getBean("eventsService", EventsService.class);
		log.info("Events - {}", eventsService.getEvents());
	}
}


