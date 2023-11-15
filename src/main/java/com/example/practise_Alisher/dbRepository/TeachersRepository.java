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
    //private JdbcTemplate jdbcTemplate;

    @Autowired
    public TeachersRepository(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        //this.jdbcTemplate = jdbcTemplate;
    }

    public RowMapper<Teachers> mapRow() {
        return (rs, rowNum) -> {
            Teachers teacher = new Teachers();
            teacher.setId(rs.getInt("teacher_id"));
            teacher.setName(rs.getString("teacher_name"));
            teacher.setLname(rs.getString("teacher_lname"));
            return teacher;
        };
    }

    public List<Teachers> getTeacher() throws SQLException{
        Statement stmt = dataSource.getConnection().createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT * from teachers");
        List<Teachers> teachers = new ArrayList<>();
        while (resultSet.next()){
            int id = resultSet.getInt("teacher_id");
            String name = resultSet.getString("teacher_name");
            String lname = resultSet.getString("teacher_lname");
            Teachers teacher = Teachers.builder().id(id).name(name).lname(lname).build();
            teachers.add(teacher);
        }
        return teachers;
    }

    public void addTeacher(int id, String name, String lname) throws SQLException{
        PreparedStatement pstm = dataSource.getConnection().prepareStatement
                ("INSERT INTO teachers(teacher_id, teacher_name, teacher_lname) VALUES (?,?,?)");
        pstm.setInt(1, id);
        pstm.setString(2, name);
        pstm.setString(3, lname);
        pstm.execute();
    }

    public Teachers findTeacherById(int id) throws SQLException {
        //return jdbcTemplate.queryForObject("SELECT * FROM teachers WHERE teacher_id = ?", this.mapRow(), id);
        Statement stmt = dataSource.getConnection().createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM teachers WHERE teacher_id =" + id);
        while (resultSet.next()){
            String name = resultSet.getString("teacher_name");
            String lname = resultSet.getString("teacher_lname");
            Teachers teacher = Teachers.builder().id(id).name(name).lname(lname).build();
            return teacher;
        }
        return Teachers.builder().build();
    }

    public Teachers findTeacherByName(String name) throws SQLException{
        Statement stmt = dataSource.getConnection().createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM teachers WHERE UPPER(teacher_name) = UPPER('" + name + "')");
        while (resultSet.next()){
            int id = resultSet.getInt("teacher_id");
            String lname = resultSet.getString("teacher_lname");
            Teachers teacher = Teachers.builder().id(id).name(name).lname(lname).build();
            return teacher;
        }
        return Teachers.builder().build();
    }
    public void deleteTeacher(int id) throws SQLException{
        String sql = "DELETE FROM teachers WHERE teacher_id = " + id;
        PreparedStatement pstm = dataSource.getConnection().prepareStatement(sql);
        pstm.execute();
    }
}