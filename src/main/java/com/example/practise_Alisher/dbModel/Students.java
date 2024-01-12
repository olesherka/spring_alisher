package com.example.practise_Alisher.dbModel;


import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
@ToString
@Getter
@Setter
public class Students {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="student_id")
    private Integer id;
    @Column(name="student_name")
    private String name;
    @Column(name="student_lname")
    private String lname;

    @ManyToOne
    @JoinColumn(name= "event_id")
    private Events event;
}
