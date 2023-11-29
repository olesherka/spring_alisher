package com.example.practise_Alisher.dbModel;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="student_id")
    private int id;
    @Column(name="student_name")
    private String name;
    @Column(name="student_lname")
    private String lname;

    @ManyToOne
    @JoinColumn(name= "event_id")
    private Events event;
}
