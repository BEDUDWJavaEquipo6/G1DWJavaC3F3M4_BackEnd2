package org.bedu.equipo6.controllers.mappers;

import org.bedu.equipo6.persistence.entities.Etapa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EtapaMapper {
    Etapa etapaModelToEtapaEntity(org.bedu.equipo6.model.Etapa etapaModel);

    org.bedu.equipo6.model.Etapa etapaEntityToEtapaModel(Etapa etapa);
}
