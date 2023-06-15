package org.bedu.equipo6.persistence;

import org.bedu.equipo6.persistence.entities.Visita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitaRepository extends JpaRepository<Visita, Long> {
}
