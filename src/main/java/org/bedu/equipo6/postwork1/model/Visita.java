package org.bedu.equipo6.postwork1.model;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class Visita {
    @NotNull
    private int id;

    @NotNull(message = "La visita debe tener un cliente objetivo")
    private Cliente cliente;

    @Future(message = "La visita debe programarse en una fecha futura")
    private LocalDateTime fechaVisita;

    @NotNull(message = "La dirección no puede estar vacía")
    private String direccion;

    @NotNull(message = "Cada visita debe tener un objetivo")
    private String objetivo;

    @NotEmpty(message = "El nombre del vendedor no puede estar vacío")
    private String vendedor;






}
