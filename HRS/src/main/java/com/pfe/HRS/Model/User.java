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
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username ;
    @Column(name = "email")
    private String email;
    String Password;
    long exercice_id ;
    private String accountType; // Add this field



}
