package com.example.practise_Alisher.dbModel;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "events")
@ToString
public class Events {
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="event_id")
    private int id;
    @Column(name="event_name")
    private String name;
    @Column(name="student_id")
    private int studentId;
    @Column(name="teacher_id")
    private int teacherId;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "event")
    Set<Students> studentsSet;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "event")
    Set<Teachers> teachersSet;

}
