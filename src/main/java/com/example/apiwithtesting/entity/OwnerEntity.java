package com.example.apiwithtesting.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "OWNER", schema = "mydb", catalog = "")
public class OwnerEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_OWNER")
    private int idOwner;
    @Basic
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Basic
    @Column(name = "LAST_NAME")
    private String lastName;

    public int getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(int idOwner) {
        this.idOwner = idOwner;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OwnerEntity that = (OwnerEntity) o;
        return idOwner == that.idOwner && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOwner, firstName, lastName);
    }
}
