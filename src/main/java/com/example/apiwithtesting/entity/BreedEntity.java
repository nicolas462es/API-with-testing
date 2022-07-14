package com.example.apiwithtesting.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Data
@Builder
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "BREED", schema = "mydb", catalog = "")
public class BreedEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_BREED")
    private int idBreed;
    @Basic
    @Column(name = "NAME")
    private String name;
}
