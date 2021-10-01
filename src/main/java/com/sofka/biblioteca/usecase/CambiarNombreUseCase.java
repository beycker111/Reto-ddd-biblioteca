package com.sofka.biblioteca.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.biblioteca.domain.libro.Libro;
import com.sofka.biblioteca.domain.libro.commands.CambiarNombre;

public class CambiarNombreUseCase extends UseCase<RequestCommand<CambiarNombre>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarNombre> cambiarNombreRequestCommand) {
        var command = cambiarNombreRequestCommand.getCommand();
        var libro = Libro.from(command.getLibroId(), retrieveEvents(command.getLibroId().value()));

        libro.cambiarNombre(command.getNombre());

        emit().onResponse(new ResponseEvents(libro.getUncommittedChanges()));

    }
}
