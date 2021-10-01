package com.sofka.biblioteca.usecase.prestamo;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.prestamo.events.MensajeEnviado;
import com.sofka.biblioteca.domain.prestamo.events.PrestamoCreado;
import com.sofka.biblioteca.domain.prestamo.values.FechaDevolucion;
import com.sofka.biblioteca.domain.prestamo.values.FechaPrestamo;
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
class AlertarPorFechasIncongruentesUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void alertarPorFechasIncongruentes(){

        //Arrange
        var aggreateId = "xxx-xxx";

        var event = new PrestamoCreado(
                new FechaPrestamo(LocalDate.now()),
                new FechaDevolucion(LocalDate.of(2021, 3, 2))
        );

        event.setAggregateRootId(aggreateId);
        var useCase = new AlertarPorFechasIncongruentesUseCase();

        Mockito.when(repository.getEventsBy(aggreateId)).thenReturn(eventStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(aggreateId)
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var eventCreado = (MensajeEnviado)events.get(1);

        Assertions.assertEquals("La fecha de devolucion no puede ser menor a la fecha de prestamo", eventCreado.getMensaje());
    }

    private List<DomainEvent> eventStored() {
        var event = new PrestamoCreado(
                new FechaPrestamo(LocalDate.now()),
                new FechaDevolucion(LocalDate.of(2021, 3, 2))
        );

        return List.of(event);
    }
}