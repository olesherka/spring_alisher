package com.example.practise_Alisher.dbModel;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teachers")
public class Teachers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name="teacher_id")
    private int id;
    @Column(name="teacher_name")
    private String name;
    @Column(name="teacher_lname")
    private String lname;

    @ManyToOne
    @JoinColumn(name= "event_id")
    private Events event;
}
