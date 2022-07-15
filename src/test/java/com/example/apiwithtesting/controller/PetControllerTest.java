package com.example.apiwithtesting.controller;

import com.example.apiwithtesting.dto.PetEntityDTO;
import com.example.apiwithtesting.entity.BreedEntity;
import com.example.apiwithtesting.entity.PetEntity;
import com.example.apiwithtesting.service.PetService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PetController.class)
class PetControllerTest {

    @MockBean
    PetService petService;

    //SuppressWarning for IntelliJ Inspection Issue
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
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
    }

    @AfterEach
    void tearDown() {
        reset(petService);
    }

    @Test
    void testGetPetById() throws Exception {
        given(petService.findById(any())).willReturn(petEntityDTO.toEntity());

        mockMvc.perform(get("/pet/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.idPet", is( petEntityDTO.getIdPet() )));
    }

    @Nested
    @DisplayName("List Ops - ")
    public class TestListOperations {
        @Captor
        ArgumentCaptor<String> petNameCaptor;

        List<PetEntity> petEntityList;

        @BeforeEach
        void setup() {
            List<PetEntityDTO> petEntityDTOList = new ArrayList<>();
            petEntityDTOList.add(petEntityDTO);
            petEntityDTOList.add(petEntityDTO);
            petEntityList = petEntityDTOList.stream()
                    .map(PetEntityDTO::toEntity).collect(Collectors.toList());

            given(petService.findAll())
                    .willReturn(petEntityList);
        }

        @Test
        @DisplayName("List pets - no args")
        void testGetAllPets() throws Exception {
            mockMvc.perform(get("/pet")
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        }
    }
}