package com.example.apiwithtesting.service;

import com.example.apiwithtesting.entity.PetEntity;
import com.example.apiwithtesting.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class PetService implements EntityServiceInterface<Integer, PetEntity>{

    PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository){
        this.petRepository = petRepository;
    }

    @Override
    public List<PetEntity> findAll() {
        return petRepository.findAll();
    }

    @Override
    public PetEntity findById(Integer id) {
        Optional<PetEntity> OptPetEntity = petRepository.findById(id);
        if (OptPetEntity.isPresent())
            return OptPetEntity.get();
        return null;
    }

    @Override
    public void deleteById(Integer integer) {
        petRepository.deleteById(integer);
    }

    @Override
    public PetEntity save(PetEntity petEntity) {
        return petRepository.save(petEntity);
    }
}
