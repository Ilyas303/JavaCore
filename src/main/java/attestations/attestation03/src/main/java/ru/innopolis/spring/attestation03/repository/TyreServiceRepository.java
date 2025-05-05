package ru.innopolis.spring.attestation03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.spring.attestation03.model.TyreService;

@Repository
public interface TyreServiceRepository extends JpaRepository<TyreService, Long> {
}