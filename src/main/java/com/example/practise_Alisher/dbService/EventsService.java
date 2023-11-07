package com.example.practise_Alisher.dbService;

import com.example.practise_Alisher.dbModel.Events;;
import com.example.practise_Alisher.dbRepository.EventsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collections;
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
        try{
            return eventsRepository.getEvent();
        }
        catch (SQLException e){
            log.error("error!!!");
            return Collections.emptyList();
        }
    }
}