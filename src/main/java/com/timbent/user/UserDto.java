package com.timbent.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name = "hebrew_lexicon")
public class UserDto {

    @Id
    private Long id;
    @Column
    private String jsonData;
}
