package com.pfe.HRS.Model;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JournalDePaie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long IdJDP;
    long IdEmp;
    long Total;
    long exercice_id ;

}

