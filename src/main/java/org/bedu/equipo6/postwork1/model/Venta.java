package org.bedu.equipo6.postwork1.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDateTime;
import java.util.List;

public class Venta {

    @NotNull
    private int ventaId;

    @PositiveOrZero(message = "El total no puede ser negativo")
    @NotEmpty
    private double total;

    @NotEmpty(message = "La venta debe contener al menos un producto válido")
    private List<Producto> productos;

    @NotNull(message = "Cada venta debe tener un cliente registrado")
    private Cliente cliente;

    @PastOrPresent(message = "La venta debe ser en una fecha anterior al día de hoy")
    private LocalDateTime fechaVenta;
}
