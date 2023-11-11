package com.example.practise_Alisher.dbRepository;

import com.example.practise_Alisher.dbModel.Students;
import com.example.practise_Alisher.dbModel.Teachers;
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
public class TeachersRepository {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TeachersRepository(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    public RowMapper<Teachers> mapRow() {
        return (rs, rowNum) -> {
            Teachers teacher = new Teachers();
            teacher.setTeacher_id(rs.getInt("teacher_id"));
            teacher.setTeacher_name(rs.getString("teacher_name"));
            teacher.setTeacher_lname(rs.getString("teacher_lname"));
            return teacher;
        };
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

    public void addTeacher(Teachers teacher) throws SQLException{
        PreparedStatement pstm = dataSource.getConnection().prepareStatement
                ("INSERT INTO teachers(teacher_id, teacher_name, teacher_lname) VALUES (?,?,?)");
        pstm.setInt(1,teacher.getTeacher_id());
        pstm.setString(2, teacher.getTeacher_name());
        pstm.setString(3, teacher.getTeacher_lname());
        pstm.execute();
    }

    public Teachers findTeacherById(int id){
        return jdbcTemplate.queryForObject("SELECT * FROM teachers WHERE teacher_id = ?", this.mapRow(), id);
    }
}