package com.sofka.biblioteca.usecase.prestamo;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.biblioteca.domain.prestamo.Prestamo;
import com.sofka.biblioteca.domain.prestamo.commands.CambiarFechaPrestamo;

public class CambiarFechaPrestamoUseCase extends UseCase<RequestCommand<CambiarFechaPrestamo>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CambiarFechaPrestamo> cambiarFechaPrestamoRequestCommand) {
        var command = cambiarFechaPrestamoRequestCommand.getCommand();
        var prestamo = Prestamo.from(command.getPrestamoId(), retrieveEvents(command.getPrestamoId().value()));

        prestamo.cambiarFechaPrestamo(command.getFechaPrestamo());

        emit().onResponse(new ResponseEvents(prestamo.getUncommittedChanges()));
    }
}
