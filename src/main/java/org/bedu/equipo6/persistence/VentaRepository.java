package org.bedu.equipo6.persistence;

import org.bedu.equipo6.persistence.entities.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta, Long> {
}
