package com.example.apiwithtesting.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TOY", schema = "mydb", catalog = "")
public class ToyEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_TOY")
    private int idToy;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "PET_ID_PET")
    private int petIdPet;

    public int getIdToy() {
        return idToy;
    }

    public void setIdToy(int idToy) {
        this.idToy = idToy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPetIdPet() {
        return petIdPet;
    }

    public void setPetIdPet(int petIdPet) {
        this.petIdPet = petIdPet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToyEntity toyEntity = (ToyEntity) o;
        return idToy == toyEntity.idToy && petIdPet == toyEntity.petIdPet && Objects.equals(name, toyEntity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idToy, name, petIdPet);
    }
}
