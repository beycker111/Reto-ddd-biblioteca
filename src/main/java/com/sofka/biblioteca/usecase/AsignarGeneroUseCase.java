package com.sofka.biblioteca.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.biblioteca.domain.libro.Libro;
import com.sofka.biblioteca.domain.libro.commands.AsignarGenero;

public class AsignarGeneroUseCase extends UseCase<RequestCommand<AsignarGenero>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsignarGenero> asignarGeneroRequestCommand) {

        var command = asignarGeneroRequestCommand.getCommand();
        var libro = Libro.from(command.getLibroId(), retrieveEvents(command.getLibroId().value()));

        libro.asignarGenero(command.getGeneroId(),
                command.getNombre(),
                command.getPublicoObjetivo());

        emit().onResponse(new ResponseEvents(libro.getUncommittedChanges()));
    }
}
