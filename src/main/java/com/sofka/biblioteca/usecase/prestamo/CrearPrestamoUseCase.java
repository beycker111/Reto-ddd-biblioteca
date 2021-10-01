package com.sofka.biblioteca.usecase.prestamo;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.biblioteca.domain.prestamo.Prestamo;
import com.sofka.biblioteca.domain.prestamo.commands.CrearPrestamo;

public class CrearPrestamoUseCase extends UseCase<RequestCommand<CrearPrestamo>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearPrestamo> crearPrestamoRequestCommand) {
        var command = crearPrestamoRequestCommand.getCommand();

        Prestamo prestamo;

        prestamo = new Prestamo(
                command.getPrestamoId(),
                command.getFechaPrestamo(),
                command.getFechaDevolucion()
        );

        emit().onResponse(new ResponseEvents(prestamo.getUncommittedChanges()));
    }
}
