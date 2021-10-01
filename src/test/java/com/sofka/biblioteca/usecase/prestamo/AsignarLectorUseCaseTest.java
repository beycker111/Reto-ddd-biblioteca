package com.sofka.biblioteca.usecase.prestamo;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.prestamo.commands.AsignarLector;
import com.sofka.biblioteca.domain.prestamo.events.LectorAsignado;
import com.sofka.biblioteca.domain.prestamo.events.PrestamoCreado;
import com.sofka.biblioteca.domain.prestamo.values.*;
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
class AsignarLectorUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void asignarLectorTest(){

        var aggregateId = "0003";
        var lectorId = "0003";
        var command = new AsignarLector(
                PrestamoId.of(aggregateId),
                LectorId.of(lectorId),
                new Nombre("Alexis"),
                new Telefono("2771882"),
                new Email("beycker_111@hotmail.com")
        );

        var useCase = new AsignarLectorUseCase();
        Mockito.when(repository.getEventsBy(aggregateId)).thenReturn(evenStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(aggregateId)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var eventAsignacionLector = (LectorAsignado)events.get(1);

        Assertions.assertEquals("Alexis", eventAsignacionLector.getNombre().value());
        Assertions.assertEquals("2771882", eventAsignacionLector.getTelefono().value());
        Assertions.assertEquals("beycker_111@hotmail.com", eventAsignacionLector.getEmail().value());
    }

    private List<DomainEvent> evenStored(){
        var eventCreacion = new PrestamoCreado(
                new FechaPrestamo(LocalDate.now()),
                new FechaDevolucion(LocalDate.of(2021, 10, 21))
        );

        return List.of(eventCreacion);
    }
}