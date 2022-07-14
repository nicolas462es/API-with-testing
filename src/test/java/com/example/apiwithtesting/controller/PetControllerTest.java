package com.example.apiwithtesting.controller;

import com.example.apiwithtesting.dto.PetEntityDTO;
import com.example.apiwithtesting.entity.BreedEntity;
import com.example.apiwithtesting.service.PetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class PetControllerTest {

    @Mock
    PetService petService;

    @InjectMocks
    PetController petController;

    MockMvc mockMvc;
    PetEntityDTO petEntityDTO;

    @BeforeEach
    void setUp() {
        petEntityDTO = PetEntityDTO.builder()
                .idPet(1)
                .name("C")
                .color("b")
                .ownerIdOwner(1)
                .breedIdBreed( new BreedEntity(1, "p"))
                .foodBag( new ArrayList<>())
                .build();
        mockMvc = MockMvcBuilders.standaloneSetup(petController).build();
    }

    @Test
    void testGetPetById() throws Exception {
        given(petService.findById(any())).willReturn(petEntityDTO.toEntity());

        mockMvc.perform(get("/pet/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.idPet", is( petEntityDTO.getIdPet() )));
    }
}