package com.example.practise_Alisher.dbRepository;

import com.example.practise_Alisher.dbModel.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EventsRepository {

    private DataSource dataSource;

    @Autowired
    public EventsRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public List<Events> getEvent() throws SQLException{
        Statement stmt = dataSource.getConnection().createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT * from events");
        List<Events> events = new ArrayList<>();
        while (resultSet.next()){
            int event_id = resultSet.getInt("event_id");
            String event_name = resultSet.getString("event_name");
            int student_id = resultSet.getInt("student_id");
            int teacher_id = resultSet.getInt("teacher_id");
            Events event = Events.builder().event_id(event_id).event_name(event_name).student_id(student_id).teacher_id(teacher_id).build();
            events.add(event);
        }
        return events;
    }
}