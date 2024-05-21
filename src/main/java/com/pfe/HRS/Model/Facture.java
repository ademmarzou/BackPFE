package com.pfe.HRS.Model;


import jakarta.persistence.MappedSuperclass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public abstract class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String typefacture;

}