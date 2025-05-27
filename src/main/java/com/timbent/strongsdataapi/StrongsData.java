package com.timbent.strongsdataapi;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name = "hebrew_lexicon")
public class StrongsData {

    @Id
    private Long id;
    @Column
    private String jsonData;
}
