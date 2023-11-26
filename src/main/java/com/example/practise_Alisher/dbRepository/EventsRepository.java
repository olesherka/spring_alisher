package com.example.practise_Alisher.dbRepository;

import com.example.practise_Alisher.dbModel.Events;
import com.example.practise_Alisher.dbModel.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventsRepository extends JpaRepository<Events, Long> {

    Events findByNameContainingIgnoreCase(String name);

    @Query("SELECT e FROM Events e WHERE LOWER(e.name) = LOWER(:name)")
    Events findByName(@Param("name") String name);
    @Transactional
    void deleteById(int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO events(event_id, event_name, student_id, teacher_id) VALUES (?,?,?,?)", nativeQuery = true)
    void insertEvent(int id, String name, int student_id, int teacher_id);

    @Query(value = "SELECT * FROM students s", nativeQuery = true)
    List<Events> getAllEventsNative();

    @Query(value = "SELECT e FROM Events e WHERE e.id = :id")
    Events findById(@Param("id") int id);

}