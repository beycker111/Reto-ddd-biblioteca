package com.sofka.biblioteca.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.biblioteca.domain.libro.Libro;
import com.sofka.biblioteca.domain.libro.commands.CambiarVecesPrestadoHistorial;
import com.sofka.biblioteca.domain.libro.values.VecesPrestado;

public class CambiarVecesPrestadoHistorialUseCase extends UseCase<RequestCommand<CambiarVecesPrestadoHistorial>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CambiarVecesPrestadoHistorial> asignarVecesPrestadoHistorialRequestCommand) {
        var command = asignarVecesPrestadoHistorialRequestCommand.getCommand();
        var libro = Libro.from(command.getLibroId(), retrieveEvents(command.getLibroId().value()));

        libro.cambiarVecesPrestadoHistorial(command.getHistorialId(), command.getVecesPrestado());

        emit().onResponse(new ResponseEvents(libro.getUncommittedChanges()));
    }
}
