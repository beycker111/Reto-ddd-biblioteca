package com.sofka.biblioteca.usecase.prestamo;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.biblioteca.domain.prestamo.Prestamo;
import com.sofka.biblioteca.domain.prestamo.commands.AsociarLibro;

public class AsociarLibroUseCase extends UseCase<RequestCommand<AsociarLibro>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsociarLibro> asociarLibroRequestCommand) {
        var command = asociarLibroRequestCommand.getCommand();
        var prestamo = Prestamo.from(command.getPrestamoId(), retrieveEvents(command.getPrestamoId().value()));

        prestamo.asociarLibro(command.getLibroId());

        emit().onResponse(new ResponseEvents(prestamo.getUncommittedChanges()));
    }
}
