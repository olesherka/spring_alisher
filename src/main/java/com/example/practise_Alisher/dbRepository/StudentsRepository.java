package com.example.practise_Alisher.dbRepository;


import com.example.practise_Alisher.dbModel.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentsRepository {

    private DataSource dataSource;

    //private JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentsRepository(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        //this.jdbcTemplate = jdbcTemplate;
    }

    public List<Students> getStudents() throws SQLException{
        Statement stmt = dataSource.getConnection().createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT * from students");
        List<Students> students = new ArrayList<>();
        while (resultSet.next()){
            int id = resultSet.getInt("student_id");
            String name = resultSet.getString("student_name");
            String lname = resultSet.getString("student_lname");
            Students student = Students.builder().id(id).name(name).lname(lname).build();
            students.add(student);
        }
        return students;
    }

    public void addStudent(int id, String name, String lname) throws SQLException{
        PreparedStatement pstm = dataSource.getConnection().prepareStatement
                ("INSERT INTO students(student_id, student_name, student_lname) VALUES (?,?,?)");
        pstm.setInt(1,id);
        pstm.setString(2, name);
        pstm.setString(3, lname);
        pstm.execute();
    }


    public Students findStudentById(int id) throws SQLException{
       // return jdbcTemplate.queryForObject("SELECT * FROM students WHERE student_id = ?", this.mapRow(), id);
        Statement stmt = dataSource.getConnection().createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM students WHERE student_id = " + id);
        while (resultSet.next()){
            String name = resultSet.getString("student_name");
            String lname = resultSet.getString("student_lname");
            Students student = Students.builder().id(id).name(name).lname(lname).build();
            return student;
        }
        return Students.builder().build();
    }

    public Students findStudentByName(String name) throws SQLException{
        //return jdbcTemplate.queryForObject("SELECT * FROM students WHERE UPPER(student_name) = UPPER(?)", this.mapRow(), student_name);
        Statement stmt = dataSource.getConnection().createStatement();
        //String sql = "SELECT * FROM students WHERE UPPER(student_name) = UPPER('" + name + "');";
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM students WHERE UPPER(student_name) = UPPER('" + name + "')");
        while (resultSet.next()){
            int id = resultSet.getInt("student_id");
            String lname = resultSet.getString("student_lname");
            Students student = Students.builder().id(id).name(name).lname(lname).build();
            return student;
        }
        return Students.builder().build();
    }
    public void deleteStudent(int id) throws SQLException{
        String sql = "DELETE FROM students WHERE student_id = " + id;
        PreparedStatement pstm = dataSource.getConnection().prepareStatement(sql);
        pstm.execute();
    }
}
