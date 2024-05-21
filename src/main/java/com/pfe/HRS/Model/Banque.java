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
public class Banque implements Serializable {
    @Id
    long id ;
    String NomCompte ;
    String libellepiece ;
    @Temporal(TemporalType.DATE)
    Date date;
    @Temporal(TemporalType.DATE)
    Date dateecheance;
    String Modedepaiement;
    @Column(name = "exercice_id")
    private Long exerciceId;
    long idpiece  ;
    long typepiece;
    long quantite ;
    long prix ;
    long debit ;


}