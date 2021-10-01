package com.sofka.biblioteca.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.biblioteca.domain.libro.commands.CrearLibro;
import com.sofka.biblioteca.domain.libro.events.LibroCreado;
import com.sofka.biblioteca.domain.libro.values.Editorial;
import com.sofka.biblioteca.domain.libro.values.LibroId;
import com.sofka.biblioteca.domain.libro.values.Resumen;
import com.sofka.biblioteca.domain.shared.values.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearLibroUseCaseTest {

    @Test
    void crearLibroTest(){
        //arrange
        var command =new CrearLibro(
                LibroId.of("0001"),
                new Nombre("Las aventuras de Beycker"),
                new Editorial("Las vegas"),
                new Resumen("Es un libro genial")
        );

        var useCase = new CrearLibroUseCase();

        //act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var eventCreacion =(LibroCreado)events.get(0);

        //assert
        Assertions.assertEquals("Las aventuras de Beycker", eventCreacion.getNombre().value());
        Assertions.assertEquals("Las vegas", eventCreacion.getEditorial().value());
        Assertions.assertEquals("Es un libro genial", eventCreacion.getResumen().value());
    }

}