package com.pfe.HRS.Model;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Vente  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id ;
    long nmrCompte ;
    long debit ;
    String libellepiece;
    @Temporal(TemporalType.DATE)
    Date date;
    @Column(name = "exercice_id")
    private Long exerciceId;
    long idpiece  ;
    long typepiece;
    String nom;
    long quantite ;
    long prix ;


}
