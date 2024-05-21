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
public class Balance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    long nmrCompte;
    long debit;
    long credit;
    long codejournal;
    String libellepiece;
    String libelledebit;
    long comptedebit;
    String libellecredit;
    long comptecredit;
    @Temporal(TemporalType.DATE)
    Date date;
    long solde;
    @Column(name = "exercice_id")
    private Long exerciceId;
}


