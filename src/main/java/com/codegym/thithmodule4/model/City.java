package com.codegym.thithmodule4.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private Long area;
    private Long population;
    private int gdp;
    private String description;

}
