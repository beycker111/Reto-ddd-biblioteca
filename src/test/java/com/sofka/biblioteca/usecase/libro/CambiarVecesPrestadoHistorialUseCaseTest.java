package com.sofka.biblioteca.usecase.libro;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.libro.commands.CambiarVecesPrestadoHistorial;
import com.sofka.biblioteca.domain.libro.events.HistorialAsignado;
import com.sofka.biblioteca.domain.libro.events.LibroCreado;
import com.sofka.biblioteca.domain.libro.events.VecesPrestadoCambiado;
import com.sofka.biblioteca.domain.libro.values.*;
import com.sofka.biblioteca.domain.shared.values.Nombre;
import com.sofka.biblioteca.usecase.libro.CambiarVecesPrestadoHistorialUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CambiarVecesPrestadoHistorialUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void cambiarVecesPrestadoHistorialTest(){

        //arrange
        var aggregateId = "0004";
        var historialId = "0004";

        var command = new CambiarVecesPrestadoHistorial(
                LibroId.of(aggregateId),
                HistorialId.of(historialId),
                new VecesPrestado(10)
        );

        var useCase = new CambiarVecesPrestadoHistorialUseCase();
        Mockito.when(repository.getEventsBy(aggregateId)).thenReturn(evenStored());
        useCase.addRepository(repository);
        //act
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(aggregateId)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (VecesPrestadoCambiado)events.get(0);
        assertEquals(10, event.getVecesPrestado().value());

    }

    private List<DomainEvent> evenStored() {
        var eventLibrocreado = new LibroCreado(
                new Nombre("Las aventuras de Beycker"),
                new Editorial("Las vegas"),
                new Resumen("Es un libro genial")
        );

        var eventHistorialCreado = new HistorialAsignado(
                HistorialId.of("0004"),
                new VecesPrestado(5)
        );

        List<DomainEvent> listaEventosDominio = new ArrayList<>();
        listaEventosDominio.add(eventLibrocreado);
        listaEventosDominio.add(eventHistorialCreado);

        return listaEventosDominio;
    }
}