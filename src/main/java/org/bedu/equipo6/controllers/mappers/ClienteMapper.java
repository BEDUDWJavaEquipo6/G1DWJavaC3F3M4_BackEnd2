package org.bedu.equipo6.controllers.mappers;

import org.bedu.equipo6.persistence.entities.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    Cliente clienteModelToClienteEntity(org.bedu.equipo6.model.Cliente clienteModel);

    org.bedu.equipo6.model.Cliente clienteEntityToClienteModel(Cliente cliente);
}
