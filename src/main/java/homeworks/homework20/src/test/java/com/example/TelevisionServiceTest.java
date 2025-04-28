package com.example;

import com.example.entity.Television;
import com.example.repository.TelevisionRepository;
import com.example.service.TelevisionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TelevisionServiceTest {

    @Mock
    private TelevisionRepository televisionRepository;

    @InjectMocks
    private TelevisionService televisionService;

    @Test
    void findAll_shouldReturnAllTelevisions() {

        Television tv1 = createTestTelevision(1L, "QN90A", "Samsung");
        Television tv2 = createTestTelevision(2L, "C1", "LG");
        when(televisionRepository.findAll()).thenReturn(List.of(tv1, tv2));


        List<Television> result = televisionService.findAll();


        assertThat(result).hasSize(2);
        assertThat(result).extracting(Television::getModel).containsExactly("QN90A", "C1");
        verify(televisionRepository, times(1)).findAll();
    }

    @Test
    void findById_shouldReturnTelevisionWhenExists() {

        Television tv = createTestTelevision(1L, "QN90A", "Samsung");
        when(televisionRepository.findById(1L)).thenReturn(Optional.of(tv));

        Television result = televisionService.findById(1L);


        assertThat(result).isNotNull();
        assertThat(result.getModel()).isEqualTo("QN90A");
        verify(televisionRepository, times(1)).findById(1L);
    }

    @Test
    void findById_shouldReturnNullWhenNotExists() {

        when(televisionRepository.findById(1L)).thenReturn(Optional.empty());


        Television result = televisionService.findById(1L);


        assertThat(result).isNull();
    }

    @Test
    void save_shouldPersistTelevision() {

        Television newTv = createTestTelevision(null, "New Model", "New Brand");
        Television savedTv = createTestTelevision(1L, "New Model", "New Brand");
        when(televisionRepository.save(any(Television.class))).thenReturn(savedTv);


        Television result = televisionService.save(newTv);


        assertThat(result.getId()).isEqualTo(1L);
        verify(televisionRepository, times(1)).save(newTv);
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