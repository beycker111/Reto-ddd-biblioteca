package com.sofka.biblioteca.usecase.libro;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.biblioteca.domain.libro.Libro;
import com.sofka.biblioteca.domain.libro.commands.CambiarResumen;

public class CambiarResumenUseCase extends UseCase<RequestCommand<CambiarResumen>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CambiarResumen> cambiarResumenRequestCommand) {
        var command = cambiarResumenRequestCommand.getCommand();
        var libro = Libro.from(command.getLibroId(), retrieveEvents(command.getLibroId().value()));

        libro.cambiarResumen(command.getResumen());

        emit().onResponse(new ResponseEvents(libro.getUncommittedChanges()));
    }
}
