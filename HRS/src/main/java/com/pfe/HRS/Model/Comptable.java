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
public class Comptable implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long IdComptable ;
    long exercice_id ;


}