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
public class JournalComptable implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id ;
    long nmrCompte ;
    long codejournal ;
    String libellepiece;
    long debit ;
    String libelledebit;
    long comptedebit;
    long credit ;
    String libellecredit;
    long comptecredit ;
    @Temporal(TemporalType.DATE)
    Date date;
    long solde ;
    boolean devis ;
    boolean bdc;
    long exercice_id ;
    long idpiece  ;
    long typepiece;
    String nom;
    @Temporal(TemporalType.DATE)
    Date dateecheance;
    String modedepaiement;
    long quantite ;
    long prix ;





}
