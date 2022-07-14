package com.example.apiwithtesting.controller;

import com.example.apiwithtesting.dto.PetEntityDTO;
import com.example.apiwithtesting.entity.PetEntity;
import com.example.apiwithtesting.entity.exception.EntityErrorResponse;
import com.example.apiwithtesting.service.PetService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("pet")
public class PetController implements RESTEntityController<Integer, PetEntityDTO> {
    private PetService petService;

    @Autowired
    public PetController(PetService petService){
        this.petService = petService;
    }

    @Override
    @Operation(summary = "Get all pets")
    public ResponseEntity<List<PetEntityDTO>> findAll() {
        return new ResponseEntity<>(
                petService.findAll().stream()
                        .map(PetEntityDTO::new)
                        .collect(Collectors.toList()),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PetEntityDTO> findById(Integer integer) {
        PetEntity pentEntity = petService.findById(integer);
        if (pentEntity == null)
            throw new EntityNotFoundException("Not found");
        return new ResponseEntity<>(
                new PetEntityDTO(pentEntity),
                HttpStatus.OK
        );
    }

    @Override
    public void deleteById(Integer integer) {
        petService.deleteById(integer);
    }

    @Override
    public ResponseEntity<PetEntityDTO> update(PetEntityDTO entityDTO) {
        return new ResponseEntity<>(
                    new PetEntityDTO(
                            petService.save(entityDTO.toEntity())
                    ),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PetEntityDTO> add(PetEntityDTO newEntity) {
        return new ResponseEntity<>(
                new PetEntityDTO(
                        petService.save(newEntity.toEntity())
                ),
                HttpStatus.OK);
    }
}
