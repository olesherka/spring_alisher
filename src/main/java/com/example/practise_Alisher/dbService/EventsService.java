package com.example.practise_Alisher.dbService;

import com.example.practise_Alisher.dbModel.Events;;
import com.example.practise_Alisher.dbModel.Students;
import com.example.practise_Alisher.dbRepository.EventsRepository;
import com.example.practise_Alisher.dbRepository.StudentsRepository;
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
    public EventsService(StudentsRepository studentsRepository){
        this.eventsRepository = eventsRepository;
    }
    public List<Events> getEvents(){
        return eventsRepository.getAllEventsNative();
    }

    public void addEvent(int id, String name, int student_id, int teacher_id){
        eventsRepository.insertEvent(id, name, student_id, teacher_id);
    }

    public Events findEventById(int id){
        return eventsRepository.findById(id);
    }

    public void deleteEventById(int id){
        eventsRepository.deleteById(id);
    }

    public Events eventByName(String name){
        return eventsRepository.findByName(name);
    }
}