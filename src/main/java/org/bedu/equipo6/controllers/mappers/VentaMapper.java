package org.bedu.equipo6.controllers.mappers;

import org.bedu.equipo6.persistence.entities.Venta;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VentaMapper {
    Venta ventaModelToVentaEntity(org.bedu.equipo6.model.Venta ventaModel);

    org.bedu.equipo6.model.Venta ventaEntityToVentaModel(Venta venta);
}
