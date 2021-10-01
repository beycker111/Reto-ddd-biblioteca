package com.sofka.biblioteca.usecase.prestamo;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.prestamo.commands.AsignarMulta;
import com.sofka.biblioteca.domain.prestamo.events.MultaAsignada;
import com.sofka.biblioteca.domain.prestamo.events.PrestamoCreado;
import com.sofka.biblioteca.domain.prestamo.values.*;
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
class AsignarMultaUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void asignarMultatorTest(){

        //arrange
        var aggregateId = "0004";
        var multaId = "0004";

        var command = new AsignarMulta(
                PrestamoId.of(aggregateId),
                MultaId.of(multaId),
                new DiasRetrasado(2),
                new ValorBaseMulta(2500)
        );

        var useCase = new AsignarMultaUseCase();
        Mockito.when(repository.getEventsBy(aggregateId)).thenReturn(evenStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(aggregateId)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var eventAsignarMulta = (MultaAsignada)events.get(1);

        Assertions.assertEquals(2, eventAsignarMulta.getDiasRetrasado().value());
        Assertions.assertEquals(2500, eventAsignarMulta.getValorBaseMulta().value());
    }

    private List<DomainEvent> evenStored(){
        var eventCreacion = new PrestamoCreado(
                new FechaPrestamo(LocalDate.now()),
                new FechaDevolucion(LocalDate.of(2021, 10, 21))
        );

        return List.of(eventCreacion);
    }
}