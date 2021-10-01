package com.sofka.biblioteca.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.biblioteca.domain.libro.Libro;
import com.sofka.biblioteca.domain.libro.commands.IncrementarVecesPrestadoHistorial;

public class IncrementarVecesPrestadoHistorialUseCase extends UseCase<RequestCommand<IncrementarVecesPrestadoHistorial>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<IncrementarVecesPrestadoHistorial> incrementarVecesPrestadoHistorialRequestCommand) {
        var command = incrementarVecesPrestadoHistorialRequestCommand.getCommand();
        var libro = Libro.from(command.getLibroId(), retrieveEvents(command.getLibroId().value()));

        libro.incrementarVecesPrestadoHistorial(command.getHistorialId(), command.getVecesPrestado());

        emit().onResponse(new ResponseEvents(libro.getUncommittedChanges()));
    }
}
