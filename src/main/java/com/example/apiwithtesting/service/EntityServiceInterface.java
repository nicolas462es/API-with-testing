package com.example.apiwithtesting.service;

import com.example.apiwithtesting.entity.PetEntity;

import java.util.List;

public interface EntityServiceInterface<ID, ENTITY>{
    public List<ENTITY> findAll();

    public ENTITY findById(ID id);

    public void deleteById(ID id);

    public ENTITY save(ENTITY entity);
}
