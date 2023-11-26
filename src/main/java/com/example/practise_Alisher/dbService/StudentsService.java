package com.example.practise_Alisher.dbService;


import com.example.practise_Alisher.dbModel.Students;
import com.example.practise_Alisher.dbRepository.StudentsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            return studentsRepository.getAllStudentsNative();
    }

    public void addStudent(int id, String name, String lname, int event_id){
        studentsRepository.insertStudent(id, name, lname, event_id);
    }

    public Students findStudentById(int id){
        return studentsRepository.findById(id);
    }

    public void deleteStudentById(int id){
        studentsRepository.deleteById(id);
    }

    public Students findStudentByName(String name){
        return studentsRepository.findByName(name);
    }
}
