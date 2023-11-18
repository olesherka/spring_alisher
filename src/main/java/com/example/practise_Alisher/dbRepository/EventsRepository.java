package com.example.practise_Alisher.dbRepository;

import com.example.practise_Alisher.dbModel.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Repository
public class EventsRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public EventsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public RowMapper<Events> mapRow() {
        return (rs, rowNum) -> {
            Events event = new Events();
            event.setId(rs.getInt("event_id"));
            event.setName(rs.getString("event_name"));
            event.setStudentId(rs.getInt("student_id"));
            event.setTeacherId(rs.getInt("teacher_id"));
            return event;
        };
    }

    public List<Events> getEvent(){
        String sql = "SELECT * from events";
        List<Events> events = jdbcTemplate.query(sql, this.mapRow());
        return events;
    }

    public void addEvent(int id, String name, int student_id, int teacher_id ){
        jdbcTemplate.update("INSERT INTO events (event_id, event_name, student_id, teacher_id) " +
                "VALUES (?,?,?,?,?)", id, name, student_id, teacher_id);
    }

    public boolean deleteEvent(int id){
        String sql = "DELETE FROM events WHERE event_id = ?";
        Object[] args = new Object[]{id};
        return jdbcTemplate.update(sql, args) == 1;
    }

    public Events findEventById(int id) {
        String sql = "SELECT * FROM events WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, mapRow());
    }

    public Events findEventByName(String name) {
        String sql = "SELECT * FROM events WHERE name = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{name}, mapRow());
    }
}