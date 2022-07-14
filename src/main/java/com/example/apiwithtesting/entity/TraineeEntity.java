package com.example.apiwithtesting.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TRAINEE", schema = "mydb", catalog = "")
public class TraineeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_TRAINEE")
    private int idTrainee;
    @Basic
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Basic
    @Column(name = "LAST_NAME")
    private String lastName;
    @Basic
    @Column(name = "PET_ID_PET")
    private int petIdPet;

    public int getIdTrainee() {
        return idTrainee;
    }

    public void setIdTrainee(int idTrainee) {
        this.idTrainee = idTrainee;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
        TraineeEntity that = (TraineeEntity) o;
        return idTrainee == that.idTrainee && petIdPet == that.petIdPet && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTrainee, firstName, lastName, petIdPet);
    }
}
