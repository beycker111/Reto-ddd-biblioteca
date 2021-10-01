package com.sofka.biblioteca.usecase.libro;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.libro.commands.AsignarGenero;
import com.sofka.biblioteca.domain.libro.events.GeneroAsignado;
import com.sofka.biblioteca.domain.libro.events.LibroCreado;
import com.sofka.biblioteca.domain.libro.values.*;
import com.sofka.biblioteca.domain.shared.values.Nombre;
import com.sofka.biblioteca.usecase.libro.AsignarGeneroUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class AsignarGeneroUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void asignarGeneroTest(){

        //arrange
        var aggregateId = "0001";
        var command = new AsignarGenero(
                LibroId.of(aggregateId),
                GeneroId.of("0001"),
                new Nombre("Terror"),
                new PublicoObjetivo("Mayores de 18")
        );

        var useCase = new AsignarGeneroUseCase();
        Mockito.when(repository.getEventsBy(aggregateId)).thenReturn(evenStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(aggregateId)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var generoAsignado = (GeneroAsignado)events.get(0);
        Assertions.assertEquals("Terror", generoAsignado.getNombre().value());

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