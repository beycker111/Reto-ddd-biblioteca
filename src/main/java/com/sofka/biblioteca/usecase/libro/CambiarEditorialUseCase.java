package com.sofka.biblioteca.usecase.libro;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.biblioteca.domain.libro.Libro;
import com.sofka.biblioteca.domain.libro.commands.CambiarEditorial;

public class CambiarEditorialUseCase extends UseCase<RequestCommand<CambiarEditorial>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CambiarEditorial> cambiarEditorialRequestCommand) {
        var command = cambiarEditorialRequestCommand.getCommand();
        var libro = Libro.from(command.getLibroId(), retrieveEvents(command.getLibroId().value()));

        libro.cambiarEditorial(command.getEditorial());

        emit().onResponse(new ResponseEvents(libro.getUncommittedChanges()));
    }
}
