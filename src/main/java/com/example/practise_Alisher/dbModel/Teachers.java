package com.example.practise_Alisher.dbModel;


import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teachers")
@ToString
public class Teachers {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY )
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
