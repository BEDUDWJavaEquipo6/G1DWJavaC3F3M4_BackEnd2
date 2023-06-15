package org.bedu.equipo6.postwork1.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class Producto {
    @NotNull
    private int id;

    @NotNull(message = "Este campo no puede estar vacío")
    private String nombre;

    @PositiveOrZero(message = "El precio no puede ser negativo")
    @NotEmpty
    private double precio;

    @NotNull(message = "El código de registro no puede estar vacío")
    private String codigoRegistro;

    @NotNull(message = "Cada producto debe tener al menos una categoria")
    private String categoria;


}
