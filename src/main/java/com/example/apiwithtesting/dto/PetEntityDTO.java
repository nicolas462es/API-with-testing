package com.example.apiwithtesting.dto;

import com.example.apiwithtesting.entity.BreedEntity;
import com.example.apiwithtesting.entity.FoodBagEntity;
import com.example.apiwithtesting.entity.PetEntity;
import lombok.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@ToString
@Builder
@AllArgsConstructor
public class PetEntityDTO {

    private int idPet;
    private String color;
    private String name;
    private int ownerIdOwner;
    private BreedEntity breedIdBreed;
    private List<FoodBagEntityDTO> foodBag;

    public PetEntityDTO(PetEntity petEntity) {
        this.idPet = petEntity.getIdPet();
        this.color = petEntity.getColor();
        this.name = petEntity.getName();
        this.ownerIdOwner = petEntity.getOwnerIdOwner();
        this.breedIdBreed = petEntity.getBreedEntity();
        this.foodBag = petEntity.getFoodBagEntitySet()
                                .stream().map(FoodBagEntityDTO::new)
                                .collect(Collectors.toList());
    }

    public PetEntity toEntity(){
        return new PetEntity().builder()
                .idPet(this.getIdPet())
                .color(this.getColor())
                .name(this.getName())
                .ownerIdOwner(this.getOwnerIdOwner())
                .breedEntity(this.getBreedIdBreed())
                .foodBagEntitySet(this.getFoodBag().stream()
                        .map(FoodBagEntityDTO::toEntity)
                        .collect(Collectors.toSet()))
                .build();
    }
}
