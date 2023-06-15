package org.bedu.equipo6.postwork1.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Cliente {

    @NotNull
    private int id;

    @NotNull(message = "Este campo no puede estar vacío")
    private String nombre;

    @NotEmpty
    private String direccion;

    @Email
    private String correo;



}
