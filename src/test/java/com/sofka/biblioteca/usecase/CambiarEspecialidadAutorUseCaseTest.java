package com.sofka.biblioteca.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.libro.commands.CambiarEspecialidadAutor;
import com.sofka.biblioteca.domain.libro.events.AutorAsignado;
import com.sofka.biblioteca.domain.libro.events.EspecialidadAutorCambiada;
import com.sofka.biblioteca.domain.libro.events.LibroCreado;
import com.sofka.biblioteca.domain.libro.values.*;
import com.sofka.biblioteca.domain.shared.values.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CambiarEspecialidadAutorUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void cambiarEspecialidadAutorTest(){

        //arrange
        var aggregateId = "0002";
        var autorId = "0002";
        var command = new CambiarEspecialidadAutor(
                LibroId.of(aggregateId),
                AutorId.of(autorId),
                new Especialidad("escribir")
        );

        var useCase = new CambiarEspecialidadAutorUseCase();
        Mockito.when(repository.getEventsBy(aggregateId)).thenReturn(evenStored());
        useCase.addRepository(repository);
        //act
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(aggregateId)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (EspecialidadAutorCambiada)events.get(0);

        assertEquals("escribir", event.getEspecialidad().value());

        Assertions.assertEquals(1, events.size());
    }

    private List<DomainEvent> evenStored() {
        var eventLibrocreado = new LibroCreado(
                new Nombre("Las aventuras de Beycker"),
                new Editorial("Las vegas"),
                new Resumen("Es un libro genial")
        );

        var eventAutorCreado = new AutorAsignado(
                AutorId.of("0002"),
                new Nombre("Beycker"),
                new Especialidad("Terror")
        );

        List<DomainEvent> listaEventosDominio = new ArrayList<>();
        listaEventosDominio.add(eventLibrocreado);
        listaEventosDominio.add(eventAutorCreado);

        return listaEventosDominio;
    }
}