package com.sofka.biblioteca.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.biblioteca.domain.libro.Libro;
import com.sofka.biblioteca.domain.libro.commands.AsignarHistorial;

public class AsignarHistorialUseCase extends UseCase<RequestCommand<AsignarHistorial>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsignarHistorial> asignarHistorialRequestCommand) {
        var command = asignarHistorialRequestCommand.getCommand();
        var libro = Libro.from(command.getLibroId(), retrieveEvents(command.getLibroId().value()));

        libro.asignarHistorial(command.getHistorialId(),
                command.getVecesPrestado()
        );

        emit().onResponse(new ResponseEvents(libro.getUncommittedChanges()));
    }
}
