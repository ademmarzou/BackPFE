package com.pfe.HRS.Model;

import lombok.*;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Bdc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    long nmrCompte;
    long debit;
    String libellepiece;
    @Temporal(TemporalType.DATE)
    Date date;
    @Column(name = "exercice_id")
    private Long exerciceId;
    String nom;
    long quantite ;
    long prix ;
}