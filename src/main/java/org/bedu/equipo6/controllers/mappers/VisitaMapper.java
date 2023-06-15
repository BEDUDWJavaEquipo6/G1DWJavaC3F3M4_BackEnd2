package org.bedu.equipo6.controllers.mappers;

import org.bedu.equipo6.persistence.entities.Visita;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VisitaMapper {
    Visita visitaModelToVisitaEntity(org.bedu.equipo6.model.Visita visitaModel);

    org.bedu.equipo6.model.Visita visitaEntityToVisitaModel(Visita visita);
}
