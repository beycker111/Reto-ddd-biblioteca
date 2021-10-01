package com.sofka.biblioteca.usecase.prestamo;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.biblioteca.domain.prestamo.Prestamo;
import com.sofka.biblioteca.domain.prestamo.commands.CambiarFechaDevolucion;

public class CambiarFechaDevolucionUseCase extends UseCase<RequestCommand<CambiarFechaDevolucion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarFechaDevolucion> cambiarFechaDevolucionRequestCommand) {
        var command = cambiarFechaDevolucionRequestCommand.getCommand();
        var prestamo = Prestamo.from(command.getPrestamoId(), retrieveEvents(command.getPrestamoId().value()));

        prestamo.cambiarFechaDevolucion(command.getFechaDevolucion());

        emit().onResponse(new ResponseEvents(prestamo.getUncommittedChanges()));
    }
}
