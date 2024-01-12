package com.example.practise_Alisher.controller;

import com.example.practise_Alisher.dbModel.Students;
import com.example.practise_Alisher.dbService.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "students/")

public class StudentController {
    private StudentsService studentsService;

    @Autowired
    public StudentController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping("getStudents/")
    public List<Students> getStudents(){
        return studentsService.getStudents();
    }

    @GetMapping("findStudent/{id}")
    public Students getStudentById(@PathVariable int id){
        return studentsService.findStudentById(id);
    }

    @PostMapping("addStudent/")
    public ResponseEntity<Students> addStudent(@RequestBody Students student){
        Students newStudent = studentsService.addStudent(student);
        return ResponseEntity.ok(newStudent);
    }

    @DeleteMapping("removeStudent/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int id){
        studentsService.deleteStudentById(id);
        return ResponseEntity.ok().body("student with id " + id + " deleted.");
    }
}
