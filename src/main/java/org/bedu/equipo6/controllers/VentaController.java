package org.bedu.equipo6.controllers;

import lombok.RequiredArgsConstructor;
import org.bedu.equipo6.services.VentaService;
import org.bedu.equipo6.model.Venta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/venta")
@RequiredArgsConstructor
public class VentaController {

    private final VentaService ventaService;

    @GetMapping("/{ventaId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Venta> getVenta(@PathVariable Long ventaId){
        Optional<Venta> ventaDb = ventaService.obtenVenta(ventaId);

        if (ventaDb.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La venta especificada no existe.");
        }

        return ResponseEntity.ok(ventaDb.get());
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity <List<Venta>> getVentas(@Valid @RequestParam Long ventaId){
        return ResponseEntity.ok(ventaService.obtenVentas());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> creaVenta(@Valid @RequestBody Venta venta, @RequestParam Long ventaId){
        Venta ventaNueva = ventaService.guardaVenta(venta);

        return ResponseEntity.created(URI.create(String.valueOf(ventaNueva.getVentaId()))).build();
    }

    @PutMapping("/{ventaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> actualizaVenta(@PathVariable Long ventaId, @Valid @RequestBody Venta venta){
        ventaService.actualizaVenta(venta);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{ventaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> eliminaVenta(@PathVariable Long ventaId){
        ventaService.eliminaVenta(ventaId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
