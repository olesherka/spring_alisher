package com.example.practise_Alisher.dbRepository;


import com.example.practise_Alisher.dbModel.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Long> {
    Students findByNameContainingIgnoreCase(String name);

    @Query("SELECT s FROM Students s WHERE LOWER(s.name) = LOWER(:name)")
    Students findByName(@Param("name") String name);
    @Transactional
    void deleteById(int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO students(student_id, student_name, student_lname, event_id) VALUES (?,?,?,?)", nativeQuery = true)
    void insertStudent(int id, String name, String lname, int event_id);

    @Query(value = "SELECT * FROM students s", nativeQuery = true)
    List<Students> getAllStudentsNative();

    @Query(value = "SELECT s FROM Students s WHERE s.id = :id")
    Students findById(@Param("id") int id);

}
