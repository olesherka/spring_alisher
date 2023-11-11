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

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentsRepository(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    public RowMapper<Students> mapRow() {
        return (rs, rowNum) -> {
            Students student = new Students();
            student.setStudent_id(rs.getInt("student_id"));
            student.setStudent_name(rs.getString("student_name"));
            student.setStudent_lname(rs.getString("student_lname"));
            return student;
        };
    }

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

    public void addStudent(Students student) throws SQLException{
        PreparedStatement pstm = dataSource.getConnection().prepareStatement
                ("INSERT INTO students(student_id, student_name, student_lname) VALUES (?,?,?)");
        pstm.setInt(1,student.getStudent_id());
        pstm.setString(2, student.getStudent_name());
        pstm.setString(3, student.getStudent_lname());
        pstm.execute();
    }
    public Students findStudentById(int id){
        return jdbcTemplate.queryForObject("SELECT * FROM students WHERE student_id = ?", this.mapRow(), id);
    }

    public Students findStudentByName(String student_name){
        return jdbcTemplate.queryForObject("SELECT * FROM students WHERE student_name LIKE ?", this.mapRow(), student_name);
    }
}
