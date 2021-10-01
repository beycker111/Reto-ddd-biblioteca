package com.sofka.biblioteca.usecase.prestamo;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.prestamo.commands.AsignarFichaBiblioteca;
import com.sofka.biblioteca.domain.prestamo.events.FichaBibliotecaAsignada;
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
class AsignarFichaBibliotecaUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void asignarFichaBibliotecaTest(){
        //arrange
        var aggregateId = "0002";
        var fichaId = "0002";
        var command = new AsignarFichaBiblioteca(
                PrestamoId.of(aggregateId),
                FichaBibliotecaId.of(fichaId),
                new NombreBiblioteca("Departamental"),
                new NombreBibliotecario("Beycker Agredo"),
                new Observacion("")
        );

        var useCase = new AsignarFichaBibliotecaUseCase();
        Mockito.when(repository.getEventsBy(aggregateId)).thenReturn(evenStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(aggregateId)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var eventAsignacionFicha = (FichaBibliotecaAsignada)events.get(1);
        Assertions.assertEquals("Departamental", eventAsignacionFicha.getNombreBiblioteca().value());
        Assertions.assertEquals("Beycker Agredo", eventAsignacionFicha.getNombreBibliotecario().value());
        Assertions.assertEquals("", eventAsignacionFicha.getObservacion().value());
    }

    private List<DomainEvent> evenStored(){
        var eventCreacion = new PrestamoCreado(
                new FechaPrestamo(LocalDate.now()),
                new FechaDevolucion(LocalDate.of(2021, 10, 21))
        );

        return List.of(eventCreacion);
    }
}