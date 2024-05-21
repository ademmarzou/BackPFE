package com.pfe.HRS.Model;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Exercice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Temporal(TemporalType.DATE)
    Date date;

    public int getYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.date);
        return calendar.get(Calendar.YEAR);
    }
}