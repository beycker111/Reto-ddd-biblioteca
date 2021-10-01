package com.sofka.biblioteca.usecase.prestamo;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.prestamo.commands.CambiarFechaDevolucion;
import com.sofka.biblioteca.domain.prestamo.events.FechaDevolucionCambiada;
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
class CambiarFechaDevolucionUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void cambiarFechaDevolucionTest(){

        var aggregateId = "0003";

        var command = new CambiarFechaDevolucion(
                PrestamoId.of(aggregateId),
                new FechaDevolucion(LocalDate.of(2021, 12, 12))
        );

        var useCase = new CambiarFechaDevolucionUseCase();
        Mockito.when(repository.getEventsBy(aggregateId)).thenReturn(evenStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(aggregateId)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var eventCambiarFechaDevolucion = (FechaDevolucionCambiada)events.get(1);

        Assertions.assertEquals(LocalDate.of(2021, 12, 12), eventCambiarFechaDevolucion.getFechaDevolucion().value());

    }

    private List<DomainEvent> evenStored(){
        var eventCreacion = new PrestamoCreado(
                new FechaPrestamo(LocalDate.now()),
                new FechaDevolucion(LocalDate.of(2021, 10, 21))
        );

        return List.of(eventCreacion);
    }
}