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
public class PlanComptable implements Serializable {
    @Id
    long Ncompte ;
    String intitule ;

}
