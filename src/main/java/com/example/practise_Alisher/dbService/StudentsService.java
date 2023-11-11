package com.example.practise_Alisher.dbService;


import com.example.practise_Alisher.dbModel.Students;
import com.example.practise_Alisher.dbRepository.StudentsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class StudentsService {
    private StudentsRepository studentsRepository;
    @Autowired
    public StudentsService(StudentsRepository studentsRepository){
        this.studentsRepository = studentsRepository;
    }
    public List<Students> getStudents(){
        try{
            return studentsRepository.getStudent();
        }
        catch (SQLException e){
            log.error("error!!!");
            return Collections.emptyList();
        }
    }

    public void addStudent(Students student){
        try{
            studentsRepository.addStudent(student);
        } catch (Exception e) {
            log.error("Error add student: {}", e.getMessage(), e);
        }
    }

    public Students findStudentById(int id){
        try{
            return studentsRepository.findStudentById(id);
        }
        catch (Exception e){
            log.error("Error find student {}", e.getMessage(), e);
            return null;
        }
    }

    public Students findStudentByName(String name){
        try{
            return studentsRepository.findStudentByName(name);
        }
        catch (Exception e){
            log.error("Error find student by name {}", e.getMessage(), e);
            return null;
        }
    }
}
