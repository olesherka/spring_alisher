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
		log.info("Student result after find by id- {}", studentsService.findStudentById(1));
		log.info("Student result after find by name- {}", studentsService.findStudentByName("alisher"));
		studentsService.addStudent(22, "cringe", "deadbrainovich", 1);
		log.info("Student - {}", studentsService.getStudents());
		log.info("Student deleting - {}", studentsService.findStudentById(22));
		studentsService.deleteStudentById(22);
		log.info("Student - {}", studentsService.getStudents());
	}
}


