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
public class AgentRH implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long IdAgentRH ;
    long exercice_id ;


}