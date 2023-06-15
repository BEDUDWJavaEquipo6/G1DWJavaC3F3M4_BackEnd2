package org.bedu.equipo6.controllers.mappers;

import org.bedu.equipo6.persistence.entities.Producto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    Producto productoModelToProductoEntity(org.bedu.equipo6.model.Producto productoModel);

    org.bedu.equipo6.model.Producto productoEntityToProductoModel(Producto producto);
}
