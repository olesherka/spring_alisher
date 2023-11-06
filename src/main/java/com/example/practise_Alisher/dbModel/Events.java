package com.example.practise_Alisher.dbModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "events")
public class Events {
    @Id
    private int event_id;
    private String event_name;
    private LocalDate event_date;
    @Id
    private int student_id;
    @Id
    private int teacher_id;
}
