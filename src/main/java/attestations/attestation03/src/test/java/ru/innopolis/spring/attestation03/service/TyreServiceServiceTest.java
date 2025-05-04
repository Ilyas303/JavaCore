package ru.innopolis.spring.attestation03.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import ru.innopolis.spring.attestation03.model.TyreService;
import ru.innopolis.spring.attestation03.repository.TyreServiceRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class TyreServiceServiceTest {
    @Autowired
    private TyreServiceService tyreServiceService;

    @MockitoBean
    private TyreServiceRepository tyreServiceRepository;

    @Test
    void shouldFindAllServices() {
        TyreService service = new TyreService();
        service.setId(1L);
        service.setName("Test Service");

        when(tyreServiceRepository.findAll()).thenReturn(List.of(service));

        List<TyreService> result = tyreServiceService.findAllServices();

        assertEquals(1, result.size());
        assertEquals("Test Service", result.get(0).getName());
    }

    @Test
    void shouldSaveService() {
        TyreService service = new TyreService();
        service.setName("New Service");

        when(tyreServiceRepository.save(any(TyreService.class))).thenReturn(service);

        TyreService result = tyreServiceService.saveService(service);

        assertNotNull(result);
        assertEquals("New Service", result.getName());
    }
}