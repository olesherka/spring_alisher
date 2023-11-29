package com.example.practise_Alisher.dbModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "events")
public class Events {
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
