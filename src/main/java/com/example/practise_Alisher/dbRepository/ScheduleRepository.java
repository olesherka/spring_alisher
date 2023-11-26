/*package com.example.practise_Alisher.dbRepository;

import com.example.practise_Alisher.dbModel.Events;
import com.example.practise_Alisher.dbModel.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Repository
public class ScheduleRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ScheduleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public RowMapper<Schedule> mapRow() {
        return (rs, rowNum) -> {
            Schedule schedule = new Schedule();
            schedule.setId(rs.getInt("schedule_id"));
            schedule.setId(rs.getInt("event_id"));
            schedule.setStudentId(rs.getInt("student_id"));
            schedule.setTeacherId(rs.getInt("teacher_id"));
            schedule.setDisciplineName(rs.getString("discipline_name"));
            return schedule;
        };
    }

    public List<Schedule> getSchedule(){
        String sql = "SELECT * from schedule";
        List<Schedule> schedule = jdbcTemplate.query(sql, this.mapRow());
        return schedule;
    }

    public void addSchedule(int id, int eventId, int student_id, int teacher_id, String discipline_name ){
        jdbcTemplate.update("INSERT INTO schedule (schedule_id, event_id, teacher_id, student_id, discipline_name) " +
                "VALUES (?,?,?,?,?)", id, eventId, student_id, teacher_id, discipline_name);
    }

    public boolean deleteSchedule(int id){
        String sql = "DELETE FROM schedule WHERE schedule_id = ?";
        Object[] args = new Object[]{id};
        return jdbcTemplate.update(sql, args) == 1;
    }

    public Schedule findScheduleById(int id) {
        String sql = "SELECT * FROM schedule WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, mapRow());
    }

    public Schedule findScheduleByDisciplineName(String name) {
        String sql = "SELECT * FROM schedule WHERE name = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{name}, mapRow());
    }
}*/