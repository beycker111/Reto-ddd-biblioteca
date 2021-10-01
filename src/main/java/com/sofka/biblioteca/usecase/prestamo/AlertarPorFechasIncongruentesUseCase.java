package com.sofka.biblioteca.usecase.prestamo;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.biblioteca.domain.prestamo.Prestamo;
import com.sofka.biblioteca.domain.prestamo.events.PrestamoCreado;
import com.sofka.biblioteca.domain.prestamo.values.PrestamoId;

public class AlertarPorFechasIncongruentesUseCase extends UseCase<TriggeredEvent<PrestamoCreado>, ResponseEvents> {

    private static final String MENSAJE = "La fecha de devolucion no puede ser menor a la fecha de prestamo";

    @Override
    public void executeUseCase(TriggeredEvent<PrestamoCreado> prestamoCreadoTriggeredEvent) {
        var event = prestamoCreadoTriggeredEvent.getDomainEvent();
        var prestamo = Prestamo.from(PrestamoId.of(event.aggregateRootId()), this.retrieveEvents());

        if(event.getFechaPrestamo().value().isAfter(event.getFechaDevolucion().value())){
            prestamo.enviarAlerta(MENSAJE);

            emit().onResponse(new ResponseEvents(prestamo.getUncommittedChanges()));
        }


    }
}
