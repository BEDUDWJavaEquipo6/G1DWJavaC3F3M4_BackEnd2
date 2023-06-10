package org.bedu.equipo6.model;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class Producto {
    @PositiveOrZero(message = "El identificador debe ser positivo o igual a cero, id>=0")
    private long id;

    @NotEmpty(message = "El nombre del producto no puede estar en blanco.")
    @Size(min = 4, max = 30, message = "El nombre del producto debe tener entre 4 y 30 letras.")
    private String nombre;

    private String categoria;

    @DecimalMin(value = "1.00", inclusive = true, message = "El precio del producto debe ser de al menos 1.00")
    private float precio;

    @NotEmpty(message = "El núemero de registro del producto no puede estar en blanco.")
    @Pattern(regexp = "^(\\d{3}[-]?){2}\\d{4}$")
    private String numeroRegistro;

    @PastOrPresent(message = "La fecha de creación del producto no puede ocurrir en el futuro.")
    private LocalDate fechaCreacion;
}