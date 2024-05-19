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
public class GrandLivre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id ;
    long nmrCompte ;
    long debit ;
    long credit ;
    @Temporal(TemporalType.DATE)
    Date date;
    long codejournal;
    String libellepiece;
    String libelledebit;
    long comptedebit;
    String libellecredit;
    long comptecredit;
    long solde;
    @Column(name = "exercice_id")
    private Long exerciceId;
    private long idpiece  ;
    private long typepiece;

}
