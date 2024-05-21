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
public class BilanFinancier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long nmrBilan;
    long nmrPieces;
    long debit ;
    long credit ;
    @Temporal(TemporalType.DATE)
    Date date;
    long exercice_id ;

}