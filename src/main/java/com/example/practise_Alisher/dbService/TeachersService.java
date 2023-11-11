package com.example.practise_Alisher.dbService;

import com.example.practise_Alisher.dbModel.Students;
import com.example.practise_Alisher.dbModel.Teachers;
import com.example.practise_Alisher.dbRepository.TeachersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class TeachersService {
    private TeachersRepository teachersRepository;
    @Autowired
    public TeachersService(TeachersRepository teachersRepository){
        this.teachersRepository = teachersRepository;
    }
    public List<Teachers> getTeachers(){
        try{
            return teachersRepository.getTeacher();
        }
        catch (SQLException e){
            log.error("error!!!");
            return Collections.emptyList();
        }
    }

    public void addTeacher(Teachers teacher){
        try{
            teachersRepository.addTeacher(teacher);
        } catch (Exception e) {
            log.error("Error add teacher: {}", e.getMessage(), e);
        }
    }

    public Teachers findTeacherById(int id){
        try{
            return teachersRepository.findTeacherById(id);
        }
        catch (Exception e){
            log.error("Error find teacher {}", e.getMessage(), e);
            return null;
        }
    }
}