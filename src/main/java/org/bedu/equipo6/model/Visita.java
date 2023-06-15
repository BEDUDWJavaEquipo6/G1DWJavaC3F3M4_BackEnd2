package org.bedu.equipo6.model;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public class Visita {
    @PositiveOrZero(message = "El identificador debe ser positivo o igual a cero, id>=0")
    private long id;

    @NotNull(message = "La visita debe haberse realizado a algún cliente.")
    private Cliente cliente;

    @Future(message = "La fecha de la cita no puede ser anterior o en una fecha en el pasado.")
    private LocalDateTime fechaProgramada;

    @NotEmpty(message = "La dirección no puede estar en blanco.")
    @Size(min = 10, message = "La dirección debe tener al menos 10 letras.")
    private String direccion;

    @NotEmpty(message = "El propósito de la visita no puede estar en blanco.")
    @Size(min = 15, message = "El propósito de la visita debe tener al menos 15 letras.")
    private String proposito;

    @NotEmpty(message = "El nombre del vendedor no puede estar en blanco.")
    @Size(min = 4, max = 30, message = "El nombre del vendedor debe tener entre 4 y 30 letras.")
    private String vendedor;
}