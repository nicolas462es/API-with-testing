package com.example.apiwithtesting.entity;

import com.example.apiwithtesting.dto.FoodBagEntityDTO;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "FOOD_BAG", schema = "mydb", catalog = "")
public class FoodBagEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_FOOD_BAG")
    private int idFoodBag;
    @Basic
    @Column(name = "NAME")
    private String name;
    @ManyToMany(mappedBy = "foodBagEntitySet")
    private Set<PetEntity> petEntity;
}
