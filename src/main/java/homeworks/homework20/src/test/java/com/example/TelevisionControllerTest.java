package com.example;


import com.example.controller.TelevisionController;
import com.example.entity.Television;
import com.example.service.TelevisionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TelevisionController.class)
class TelevisionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TelevisionService televisionService;

    @Test
    void getAllTelevisions_shouldReturnTelevisions() throws Exception {

        Television tv1 = createTestTelevision(1L, "QN90A", "Samsung");
        Television tv2 = createTestTelevision(2L, "C1", "LG");
        when(televisionService.findAll()).thenReturn(List.of(tv1, tv2));


        mockMvc.perform(get("/api/televisions"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].model").value("QN90A"))
                .andExpect(jsonPath("$[1].manufacturer").value("LG"));
    }

    @Test
    void getTelevisionById_shouldReturnTelevision() throws Exception {

        Television tv = createTestTelevision(1L, "QN90A", "Samsung");
        when(televisionService.findById(1L)).thenReturn(tv);


        mockMvc.perform(get("/api/televisions/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.model").value("QN90A"))
                .andExpect(jsonPath("$.manufacturer").value("Samsung"));
    }

    @Test
    void createTelevision_shouldReturnCreatedTelevision() throws Exception {

        Television newTv = createTestTelevision(null, "New Model", "New Brand");
        Television savedTv = createTestTelevision(1L, "New Model", "New Brand");
        when(televisionService.save(any(Television.class))).thenReturn(savedTv);


        mockMvc.perform(post("/api/televisions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "model": "New Model",
                                    "manufacturer": "New Brand",
                                    "screenSize": 55.0,
                                    "resolutionWidth": 3840,
                                    "resolutionHeight": 2160,
                                    "smartTv": true,
                                    "price": 1299.99
                                }"""))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.model").value("New Model"));
    }

    private Television createTestTelevision(Long id, String model, String manufacturer) {
        Television tv = new Television();
        tv.setId(id);
        tv.setModel(model);
        tv.setManufacturer(manufacturer);
        tv.setScreenSize(55.0f);
        tv.setResolutionWidth(3840);
        tv.setResolutionHeight(2160);
        tv.setSmartTv(true);
        tv.setPrice(BigDecimal.valueOf(1299.99));
        return tv;
    }
}