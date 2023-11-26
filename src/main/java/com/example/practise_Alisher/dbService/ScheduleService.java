/*package com.example.practise_Alisher.dbService;

import com.example.practise_Alisher.dbModel.Events;;
import com.example.practise_Alisher.dbModel.Schedule;
import com.example.practise_Alisher.dbRepository.EventsRepository;
import com.example.practise_Alisher.dbRepository.ScheduleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class ScheduleService {
    private ScheduleRepository scheduleRepository;
    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository){
        this.scheduleRepository = scheduleRepository;
    }
    public List<Schedule> getSchedule(){
        return scheduleRepository.getSchedule();
    }
    public void addSchedule(int id, int eventId, int student_id, int teacher_id, String discipline_name ){
        scheduleRepository.addSchedule(id, eventId, student_id, teacher_id, discipline_name);
    }
    public void deleteSchedule(int id){
        scheduleRepository.deleteSchedule(id);
    }
    public Schedule findScheduleById(int id){
        return scheduleRepository.findScheduleById(id);
    }
    public Schedule findScheduleByDisciplineName(String name){
        return scheduleRepository.findScheduleByDisciplineName(name);
    }
}
*/