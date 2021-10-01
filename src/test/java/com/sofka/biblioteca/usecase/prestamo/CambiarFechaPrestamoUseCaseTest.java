package com.sofka.biblioteca.usecase.prestamo;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.prestamo.commands.CambiarFechaPrestamo;
import com.sofka.biblioteca.domain.prestamo.events.FechaPrestamoCambiada;
import com.sofka.biblioteca.domain.prestamo.events.PrestamoCreado;
import com.sofka.biblioteca.domain.prestamo.values.FechaDevolucion;
import com.sofka.biblioteca.domain.prestamo.values.FechaPrestamo;
import com.sofka.biblioteca.domain.prestamo.values.PrestamoId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CambiarFechaPrestamoUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void cambiarFechaPrestamoTest(){

        //arrange
        var aggregateId = "0007";

        var command = new CambiarFechaPrestamo(
                PrestamoId.of(aggregateId),
                new FechaPrestamo(LocalDate.of(2021, 11, 10))
        );

        var useCase = new CambiarFechaPrestamoUseCase();
        Mockito.when(repository.getEventsBy(aggregateId)).thenReturn(evenStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(aggregateId)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var eventCambiarFechaPrestamo = (FechaPrestamoCambiada)events.get(1);

        Assertions.assertEquals(LocalDate.of(2021, 11, 10), eventCambiarFechaPrestamo.getFechaPrestamo().value());
    }

    private List<DomainEvent> evenStored(){
        var eventCreacion = new PrestamoCreado(
                new FechaPrestamo(LocalDate.now()),
                new FechaDevolucion(LocalDate.of(2021, 10, 21))
        );

        return List.of(eventCreacion);
    }
}