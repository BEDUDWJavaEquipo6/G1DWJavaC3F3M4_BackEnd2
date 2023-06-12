package org.bedu.equipo6.controllers.handlers;

import org.bedu.equipo6.model.RespuestaError;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//Iteracion 2 para eliminar problema de Method does not override method from its superclass
//Probando con @ControllerAdvice
/*
@ControllerAdvice
public class ManejadorGlobalExcepciones extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                               HttpHeaders headers,
                                                               HttpStatus status,
                                                               WebRequest request) {
        Map<String, String> errors = new TreeMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.put(error.getObjectName(), error.getDefaultMessage());
        }
        RespuestaError respuestaError = new RespuestaError();
        respuestaError.setErrores(errors);
        respuestaError.setRuta(request.getDescription(false).substring(4));
        return handleExceptionInternal(
                ex, respuestaError, headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ResponseBody
    public ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
                                                                      HttpHeaders headers,
                                                                      HttpStatus status,
                                                                      WebRequest request) {

        Map<String, String> errors = new HashMap<>();

        StringBuilder builder = new StringBuilder();
        builder.append("El método ");
        builder.append(ex.getMethod());
        builder.append(" no está soportado para esta petición. Los métodos soportados son ");

        ex.getSupportedHttpMethods().forEach(t -> builder.append(t + " "));

        errors.put("Error", builder.toString());
        RespuestaError respuestaError = new RespuestaError();
        respuestaError.setErrores(errors);
        respuestaError.setRuta(request.getDescription(false).substring(4));

        return new ResponseEntity<>(respuestaError, new HttpHeaders(), HttpStatus.METHOD_NOT_ALLOWED);
    }
}
*/
// iteracion 3
/*
@RestControllerAdvice
public class ManejadorGlobalExcepciones extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    //@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        Map<String, String> errors = new TreeMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.put(error.getObjectName(), error.getDefaultMessage());
        }
        RespuestaError respuestaError = new RespuestaError();
        respuestaError.setErrores(errors);
        respuestaError.setRuta(request.getDescription(false).substring(4));
        return handleExceptionInternal(
                ex, respuestaError, headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    //@Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        Map<String, String> errors = new TreeMap<>();

        StringBuilder builder = new StringBuilder();
        builder.append("El método ");
        builder.append(ex.getMethod());
        builder.append(" no está soportado para esta petición. Los métodos soportados son ");

        ex.getSupportedHttpMethods().forEach(t -> builder.append(t + " "));

        errors.put("Error", builder.toString());
        RespuestaError respuestaError = new RespuestaError();
        respuestaError.setErrores(errors);
        respuestaError.setRuta(request.getDescription(false).substring(4));

        return new ResponseEntity<Object>(respuestaError, new HttpHeaders(), HttpStatus.METHOD_NOT_ALLOWED);
    }
}
*/
//Esta iteracion 1 es copia de la app Bedu, pero el codigo levanta dos errores
//Method does not override method from its superclass

@RestControllerAdvice
public class ManejadorGlobalExcepciones extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, String> errors = new TreeMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.put(error.getObjectName(), error.getDefaultMessage());
        }
        RespuestaError respuestaError = new RespuestaError();
        respuestaError.setErrores(errors);
        respuestaError.setRuta(request.getDescription(false).substring(4));
        return handleExceptionInternal(
                ex, respuestaError, headers, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        Map<String, String> errors = new TreeMap<>();

        StringBuilder builder = new StringBuilder();
        builder.append("El método ");
        builder.append(ex.getMethod());
        builder.append(" no está soportado para esta petición. Los métodos soportados son ");

        ex.getSupportedHttpMethods().forEach(t -> builder.append(t + " "));

        errors.put("Error", builder.toString());
        RespuestaError respuestaError = new RespuestaError();
        respuestaError.setErrores(errors);
        respuestaError.setRuta(request.getDescription(false).substring(4));

        return new ResponseEntity<Object>(respuestaError, new HttpHeaders(), HttpStatus.METHOD_NOT_ALLOWED);
    }
}
