package com.example.practise_Alisher.exec_sch;

import com.example.practise_Alisher.dbModel.Students;
import com.example.practise_Alisher.dbService.StudentsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

@Service
@Slf4j
public class SmthMethod implements Runnable{
    private StudentsService studentsService;
    @Autowired
    public SmthMethod(StudentsService studentsService){
        this.studentsService = studentsService;
    }
    @Override
    public void run(){
        List<Students> students = studentsService.getStudents();
        int cnt = 0;
        while (cnt < 3){
            log.info(students.get(cnt).toString());
            cnt++;
        }
        log.info("runnable method finished");
    }
}
