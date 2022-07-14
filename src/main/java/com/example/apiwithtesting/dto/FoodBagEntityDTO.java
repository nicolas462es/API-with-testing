package com.example.apiwithtesting.dto;

import com.example.apiwithtesting.entity.FoodBagEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class FoodBagEntityDTO {
    private int idFoodBag;
    private String name;

    public FoodBagEntityDTO(FoodBagEntity foodBagEntity){
        this.idFoodBag = foodBagEntity.getIdFoodBag();
        this.name = foodBagEntity.getName();
    }

    public FoodBagEntity toEntity(){
        return new FoodBagEntity().builder()
                .idFoodBag(this.idFoodBag)
                .name(this.name)
                .build();
    }
}
