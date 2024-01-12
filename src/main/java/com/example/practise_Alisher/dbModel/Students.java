package com.example.practise_Alisher.dbModel;


import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
@ToString
public class Students {
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setEvent(Events event) {
        this.event = event;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLname() {
        return lname;
    }

    public Events getEvent() {
        return event;
    }

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
