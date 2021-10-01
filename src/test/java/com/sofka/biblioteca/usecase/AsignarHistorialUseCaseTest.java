package com.sofka.biblioteca.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.libro.commands.AsignarHistorial;
import com.sofka.biblioteca.domain.libro.events.HistorialAsignado;
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
class AsignarHistorialUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void asignarHistorialTest(){

        //arrange
        var aggregateId = "0003";
        var historialId = "0003";
        var command = new AsignarHistorial(
                LibroId.of(aggregateId),
                HistorialId.of(historialId),
                new VecesPrestado(4)
        );

        var useCase = new AsignarHistorialUseCase();
        Mockito.when(repository.getEventsBy(aggregateId)).thenReturn(evenStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(aggregateId)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (HistorialAsignado)events.get(0);
        //assert
        Assertions.assertEquals(4, event.getVecesPrestado().value());


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