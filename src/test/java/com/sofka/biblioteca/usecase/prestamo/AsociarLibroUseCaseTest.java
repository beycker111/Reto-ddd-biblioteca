package com.sofka.biblioteca.usecase.prestamo;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.libro.values.LibroId;
import com.sofka.biblioteca.domain.prestamo.commands.AsociarLibro;
import com.sofka.biblioteca.domain.prestamo.events.LibroAsociado;
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
class AsociarLibroUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void asociarLibroTest(){

        var aggregateId = "0005";
        var libroId = "0005";

        var command = new AsociarLibro(
                PrestamoId.of(aggregateId),
                LibroId.of(libroId)
        );

        var useCase = new AsociarLibroUseCase();
        Mockito.when(repository.getEventsBy(aggregateId)).thenReturn(evenStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(aggregateId)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var eventAsociarLibro = (LibroAsociado)events.get(1);

        Assertions.assertEquals("0005", eventAsociarLibro.getLibroId().value());
    }

    private List<DomainEvent> evenStored(){
        var eventCreacion = new PrestamoCreado(
                new FechaPrestamo(LocalDate.now()),
                new FechaDevolucion(LocalDate.of(2021, 10, 21))
        );

        return List.of(eventCreacion);
    }
}