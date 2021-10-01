package com.sofka.biblioteca.usecase.libro;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.biblioteca.domain.libro.Libro;
import com.sofka.biblioteca.domain.libro.events.GeneroAsignado;
import com.sofka.biblioteca.domain.libro.values.LibroId;

public class AlertarPorGeneroNoValidoUseCase extends UseCase<TriggeredEvent<GeneroAsignado>, ResponseEvents> {

    private static final String MENSAJE = "El género del libro no es válido";

    @Override
    public void executeUseCase(TriggeredEvent<GeneroAsignado> generoAsignadoTriggeredEvent) {
        var event = generoAsignadoTriggeredEvent.getDomainEvent();
        var libro = Libro.from(LibroId.of(event.aggregateRootId()), this.retrieveEvents());

        if(!event.getNombre().value().equals("Terror") && !event.getNombre().value().equals("Comedia") && !event.getNombre().value().equals("Drama")){
            libro.enviarAlerta(MENSAJE);

            emit().onResponse(new ResponseEvents(libro.getUncommittedChanges()));
        }
    }
}
