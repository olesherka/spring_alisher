package com.example.practise_Alisher.exec_sch;

import com.example.practise_Alisher.dbModel.Students;
import com.example.practise_Alisher.dbModel.Teachers;
import com.example.practise_Alisher.dbService.StudentsService;
import com.example.practise_Alisher.dbService.TeachersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;

@Service
@Slf4j
public class Schedule {
    private StudentsService studentsService;
    private TeachersService teachersService;

    @Autowired
    public Schedule(StudentsService studentsService, TeachersService teachersService) {
        this.studentsService = studentsService;
        this.teachersService = teachersService;
    }

    @Scheduled(fixedDelay = 4500)
    public void fixedDelayTask(){
        Iterable<Students> students = studentsService.getStudents();
        log.info("all students : {}", students);
    }

    @Async
    @Scheduled(fixedRate = 3000)
    public void fixedRateTask(){
        Iterable<Students> students = studentsService.getStudents();
        log.info("all students : {}", students);
    }

    @Scheduled(cron = "0/10 * * * *?")
    public void cronExpressionMethod(){
        Iterator<Students> students = studentsService.getStudents().iterator();
        Iterator<Teachers> teachers = teachersService.getTeachers().iterator();
        for(int i = 0; i < 5; i++){
            if (i % 2 == 0 && students.hasNext()){
                log.info("student : {}", students.next());
            }
            else{
                log.info("students is empty!");
            }
            if (i % 2 != 0 && teachers.hasNext()){
                log.info("teacher : {}", teachers.next());
            }
            else{
                log.info("teachers is empty!");
            }
        }
    }
}
