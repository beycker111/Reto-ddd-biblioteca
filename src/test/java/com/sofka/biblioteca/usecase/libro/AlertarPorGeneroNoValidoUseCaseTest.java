package com.sofka.biblioteca.usecase.libro;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.libro.events.GeneroAsignado;
import com.sofka.biblioteca.domain.libro.events.MensajeEnviado;
import com.sofka.biblioteca.domain.libro.values.GeneroId;
import com.sofka.biblioteca.domain.libro.values.PublicoObjetivo;
import com.sofka.biblioteca.domain.prestamo.events.PrestamoCreado;
import com.sofka.biblioteca.domain.prestamo.values.FechaDevolucion;
import com.sofka.biblioteca.domain.prestamo.values.FechaPrestamo;
import com.sofka.biblioteca.domain.shared.values.Nombre;
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
class AlertarPorGeneroNoValidoUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void alertarPorGeneroNoValido(){

        var aggreateId = "xxx-xxx";
        var generoId = "xxx-xxx";

        var event = new GeneroAsignado(
                GeneroId.of(generoId),
                new Nombre("Amor"),
                new PublicoObjetivo("Mayores de 19")
        );

        event.setAggregateRootId(aggreateId);
        var useCase = new AlertarPorGeneroNoValidoUseCase();
        Mockito.when(repository.getEventsBy(aggreateId)).thenReturn(eventStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(aggreateId)
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var eventMensaje = (MensajeEnviado)events.get(0);

        Assertions.assertEquals("El género del libro no es válido", eventMensaje.getMensaje());
    }

    private List<DomainEvent> eventStored() {
        var event = new PrestamoCreado(
                new FechaPrestamo(LocalDate.now()),
                new FechaDevolucion(LocalDate.of(2021, 3, 2))
        );

        return List.of(event);
    }

}