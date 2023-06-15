package org.bedu.equipo6.controllers.handlers;

import org.bedu.equipo6.model.RespuestaError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ManejadorGlobalErrores {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleStatusException(MethodArgumentNotValidException ex,
                                                   WebRequest request) {

        return RespuestaError.builder()
                .exception(ex)
                .mensaje("MethodArgumentNotValidException.\nOcurrió un error al validar la información de la petición.")
                .ruta(request.getDescription(false).substring(4))
                .entidad();
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<?> handleStatusException(HttpRequestMethodNotSupportedException ex,
                                                   WebRequest request) {

        return RespuestaError.builder()
                //.exception(ex)
                .status(HttpStatus.METHOD_NOT_ALLOWED)
                .mensaje("HttpRequestMethodNotSupportedException.\nno está soportado para esta petición.")
                .ruta(request.getDescription(false).substring(4))
                .entidad();
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> manejaException(Exception ex, WebRequest request) {
        return RespuestaError.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .mensaje("Exception.\nOcurrió un error al procesar la petición")
                .ruta(request.getDescription(false).substring(4))
                .entidad();
    }
}
