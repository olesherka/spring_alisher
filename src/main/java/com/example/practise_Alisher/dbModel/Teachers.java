package com.example.practise_Alisher.dbModel;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teachers")
public class Teachers {
    @Id
    private int teacher_id;
    private String teacher_name;
    private String teacher_lname;
}
