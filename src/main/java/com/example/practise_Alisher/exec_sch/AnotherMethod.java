package com.example.practise_Alisher.exec_sch;

import com.example.practise_Alisher.dbModel.Teachers;
import com.example.practise_Alisher.dbService.TeachersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Stream;

@Service
@Slf4j
public class AnotherMethod implements Callable<ArrayList<Teachers>> {

    private TeachersService teachersService;
    private String name = "Alisher";

    @Autowired
    public AnotherMethod(TeachersService teachersService){
        this.teachersService = teachersService;
    }
    @Override
    public ArrayList<Teachers> call() throws InterruptedException{
        ArrayList<Teachers> teachers = new ArrayList<>();
        int cnt = 0;
        while(cnt < 3){
            teachers.add(teachersService.findTeacherByName(name));
            cnt++;
        }
        return teachers;
    }
}
