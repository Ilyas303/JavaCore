package com.example;


import com.example.entity.Television;
import com.example.repository.TelevisionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class TelevisionRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TelevisionRepository televisionRepository;

    @Test
    void whenFindAll_thenReturnAllTelevisions() {

        Television tv1 = createAndPersistTelevision("QN90A", "Samsung");
        Television tv2 = createAndPersistTelevision("C1", "LG");


        List<Television> found = televisionRepository.findAll();


        assertThat(found).hasSize(2);
        assertThat(found).extracting(Television::getModel).containsExactly("QN90A", "C1");
    }

    @Test
    void whenFindById_thenReturnTelevision() {

        Television tv = createAndPersistTelevision("QN90A", "Samsung");


        Television found = televisionRepository.findById(tv.getId()).orElse(null);


        assertThat(found).isNotNull();
        assertThat(found.getModel()).isEqualTo("QN90A");
    }

    private Television createAndPersistTelevision(String model, String manufacturer) {
        Television tv = new Television();
        tv.setModel(model);
        tv.setManufacturer(manufacturer);
        tv.setScreenSize(55.0f);
        tv.setResolutionWidth(3840);
        tv.setResolutionHeight(2160);
        tv.setSmartTv(true);
        tv.setPrice(BigDecimal.valueOf(1299.99));
        return entityManager.persistAndFlush(tv);
    }
}