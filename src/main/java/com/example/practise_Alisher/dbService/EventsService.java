package com.example.practise_Alisher.dbService;

import com.example.practise_Alisher.dbModel.Events;;
import com.example.practise_Alisher.dbRepository.EventsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class EventsService {
    private EventsRepository eventsRepository;
    @Autowired
    public EventsService(EventsRepository eventsRepository){
        this.eventsRepository = eventsRepository;
    }
    public List<Events> getEvents(){
        return eventsRepository.getEvent();
    }
    public void addEvent(int id, String name, int student_id, int teacher_id ){
        eventsRepository.addEvent(id, name, student_id, teacher_id );
    }
    public void deleteEvent(int id){
        eventsRepository.deleteEvent(id);
    }
    public Events findEventbyId(int id){
        return eventsRepository.findEventById(id);
    }
    public Events findEventByName(String name){
        return eventsRepository.findEventByName(name);
    }
}