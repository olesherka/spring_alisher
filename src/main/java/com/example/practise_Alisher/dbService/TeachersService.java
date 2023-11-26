package com.example.practise_Alisher.dbService;

import com.example.practise_Alisher.dbModel.Students;
import com.example.practise_Alisher.dbModel.Teachers;
import com.example.practise_Alisher.dbRepository.StudentsRepository;
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
        return teachersRepository.getAllTeachersNative();
    }

    public void addTeacher(int id, String name, String lname, int event_id){
        teachersRepository.insertTeacher(id, name, lname, event_id);
    }

    public Teachers findTeacherById(int id){
        return teachersRepository.findById(id);
    }

    public void deleteTeacherById(int id){
        teachersRepository.deleteById(id);
    }

    public Teachers findTeacherByName(String name){
        return teachersRepository.findByName(name);
    }
}
