package com.example.practise_Alisher.dbService;


import com.example.practise_Alisher.dbModel.Students;
import com.example.practise_Alisher.dbRepository.StudentsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class StudentsService {
    private StudentsRepository studentsRepository;

    @Autowired
    public StudentsService(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public List<Students> getStudents() {
        return studentsRepository.getAllStudentsNative();
    }

    public Students addStudent(Students student) {
        if (studentsRepository.findById(student.getId()) == null) {
            return studentsRepository.save(student);
        } else {
            throw new IllegalStateException("Student with id(" + student.getId() + ") already exist");
        }
    }

    public Students findStudentById(int id) {
        return studentsRepository.findById(id);
    }

    public void deleteStudentById(int id) {
        studentsRepository.deleteById(id);
    }

    public Students findStudentByName(String name) {
        return studentsRepository.findByName(name);
    }

    public Students updateStudent(int id, Students student) {
        if (studentsRepository.findById(id) != null) {
            student.setId(id);
            return studentsRepository.save(student);
        } else {
            throw new NoSuchElementException("Student with id(" + id + ") not found");
        }
    }
}
