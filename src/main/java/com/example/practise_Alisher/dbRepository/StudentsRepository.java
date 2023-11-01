package com.example.practise_Alisher.dbRepository;


import com.example.practise_Alisher.dbModel.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentsRepository {
    @Autowired
    private DataSource dataSource;

    public List<Students> getStudent() throws SQLException{
        Statement stmt = dataSource.getConnection().createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT * from students");
        List<Students> students = new ArrayList<>();
        while (resultSet.next()){
            int student_id = resultSet.getInt("student_id");
            String student_name = resultSet.getString("student_name");
            String student_lname = resultSet.getString("student_lname");
            Students student = Students.builder().student_id(student_id).student_name(student_name).student_lname(student_lname).build();
            students.add(student);
        }
        return students;
    }
}
