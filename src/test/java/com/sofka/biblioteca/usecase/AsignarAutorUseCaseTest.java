package com.sofka.biblioteca.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.libro.Libro;
import com.sofka.biblioteca.domain.libro.commands.AsignarAutor;
import com.sofka.biblioteca.domain.libro.commands.CrearLibro;
import com.sofka.biblioteca.domain.libro.events.AutorAsignado;
import com.sofka.biblioteca.domain.libro.events.LibroCreado;
import com.sofka.biblioteca.domain.libro.values.*;
import com.sofka.biblioteca.domain.shared.values.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AsignarAutorUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void asignarAutorTest(){

        //arrange
        var aggregateId = "0002";
        var command = new AsignarAutor(
                LibroId.of(aggregateId),
                AutorId.of("0001"),
                new Nombre("Beycker"),
                new Especialidad("Sistemas")
        );

        var useCase = new AsignarAutorUseCase();
        Mockito.when(repository.getEventsBy(aggregateId)).thenReturn(evenStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(aggregateId)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (AutorAsignado)events.get(0);

        //assert
        Assertions.assertEquals("Beycker", event.getNombre().value());

        Assertions.assertEquals(1, events.size());
    }

    private List<DomainEvent> evenStored() {
        var event = new LibroCreado(
                new Nombre("Las aventuras de Beycker"),
                new Editorial("Las vegas"),
                new Resumen("Es un libro genial")
        );

        return List.of(event);
    }

}