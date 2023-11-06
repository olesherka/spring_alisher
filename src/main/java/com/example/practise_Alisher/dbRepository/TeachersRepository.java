package com.example.practise_Alisher.dbRepository;

import com.example.practise_Alisher.dbModel.Teachers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TeachersRepository {

    private DataSource dataSource;

    @Autowired
    public TeachersRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public List<Teachers> getTeacher() throws SQLException{
        Statement stmt = dataSource.getConnection().createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT * from teachers");
        List<Teachers> teachers = new ArrayList<>();
        while (resultSet.next()){
            int teacher_id = resultSet.getInt("teacher_id");
            String teacher_name = resultSet.getString("teacher_name");
            String teacher_lname = resultSet.getString("teacher_name");
            Teachers teacher = Teachers.builder().teacher_id(teacher_id).teacher_name(teacher_name).teacher_lname(teacher_lname).build();
            teachers.add(teacher);
        }
        return teachers;
    }
}