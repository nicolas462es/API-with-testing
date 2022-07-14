package com.example.apiwithtesting.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Getter
@Setter
@Builder
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "PET", schema = "mydb", catalog = "")
public class PetEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_PET")
    private int idPet;
    @Basic
    @Column(name = "COLOR")
    private String color;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "OWNER_ID_OWNER")
    private int ownerIdOwner;
    @ManyToOne
    @JoinColumn(name = "BREED_ID_BREED")
    private BreedEntity breedEntity;
    @ManyToMany
    @JoinTable(
            name = "PET_FOOD",
            joinColumns = @JoinColumn(name = "PET_ID_PET"),
            inverseJoinColumns = @JoinColumn(name = "FOOD_BAG_ID_FOOD_BAG"))
    private Set<FoodBagEntity> foodBagEntitySet;
}
