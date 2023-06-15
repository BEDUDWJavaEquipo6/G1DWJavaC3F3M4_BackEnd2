package org.bedu.equipo6.postwork1.model;

import jakarta.validation.constraints.NotNull;

public class Etapa {
    @NotNull
    private int etapaId;

    @NotNull(message = "Este campo no puede estar vacío")
    private String nombre;



}
