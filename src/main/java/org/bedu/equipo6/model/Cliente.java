package org.bedu.equipo6.model;

import jakarta.validation.constraints.*;

public class Cliente {
    @PositiveOrZero(message = "El identificador debe ser positivo o igual a cero, id>=0")
    private long id;

    @NotEmpty(message = "El nombre del cliente no puede estar vacío")
    @Size(min = 5, max = 30, message = "El nombre del cliente debe tener al menos 5 letras y ser menor a 30")
    private String nombre;

    @Email
    private String correoContacto;

    @Min(value = 10, message = "Los clientes con menos de 10 empleados no son válidos")
    @Max(value = 10000, message = "Los clientes con más de 10000 empleados no son válidos")
    private String numeroEmpleados;

    @NotBlank(message = "Se debe proporcionar una dirección")
    private String direccion;

    /* Ejemplo de Cleinte
    {
    "id":1,
     "nombre":"Mark Spielberg",
     "correoContacto":"amigo@gmail.com",
     "numeroEmpleados":100,
     "direccion":"Felix Cuevas 15"
     }
     */
}