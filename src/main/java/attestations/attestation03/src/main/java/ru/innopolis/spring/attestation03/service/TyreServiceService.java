package ru.innopolis.spring.attestation03.service;

import org.springframework.stereotype.Service;
import ru.innopolis.spring.attestation03.model.TyreService;
import ru.innopolis.spring.attestation03.repository.TyreServiceRepository;

import java.util.List;


@Service
public class TyreServiceService {
    private final TyreServiceRepository serviceRepository;

    public TyreServiceService( TyreServiceRepository  serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<TyreService> findAllServices() {
        return serviceRepository.findAll();
    }

    public TyreService findServiceById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    public TyreService saveService(TyreService service) {
        return serviceRepository.save(service);
    }

    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }
}