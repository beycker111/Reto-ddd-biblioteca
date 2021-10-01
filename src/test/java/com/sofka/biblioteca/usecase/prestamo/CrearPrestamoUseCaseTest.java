package com.sofka.biblioteca.usecase.prestamo;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.biblioteca.domain.prestamo.commands.CrearPrestamo;
import com.sofka.biblioteca.domain.prestamo.events.PrestamoCreado;
import com.sofka.biblioteca.domain.prestamo.values.FechaDevolucion;
import com.sofka.biblioteca.domain.prestamo.values.FechaPrestamo;
import com.sofka.biblioteca.domain.prestamo.values.PrestamoId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CrearPrestamoUseCaseTest {

    @Test
    void crearPrestamooTest() {
        //arrange

        var command = new CrearPrestamo(
                PrestamoId.of("0001"),
                new FechaPrestamo(LocalDate.now()),
                new FechaDevolucion(LocalDate.of(2021, 10, 10))
        );

        var useCase = new CrearPrestamoUseCase();

        //act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var eventCreacion = (PrestamoCreado)events.get(0);

        Assertions.assertEquals(LocalDate.now(), eventCreacion.getFechaPrestamo().value());
        Assertions.assertEquals(LocalDate.of(2021, 10, 10), eventCreacion.getFechaDevolucion().value());
    }
}