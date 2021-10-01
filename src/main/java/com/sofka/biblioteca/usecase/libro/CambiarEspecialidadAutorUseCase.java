package com.sofka.biblioteca.usecase.libro;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.biblioteca.domain.libro.Libro;
import com.sofka.biblioteca.domain.libro.commands.CambiarEspecialidadAutor;
import com.sofka.biblioteca.domain.libro.values.*;
import com.sofka.biblioteca.domain.shared.values.Nombre;

public class CambiarEspecialidadAutorUseCase extends UseCase<RequestCommand<CambiarEspecialidadAutor>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CambiarEspecialidadAutor> cambiarEspecialidadAutorRequestCommand) {
        var command = cambiarEspecialidadAutorRequestCommand.getCommand();
        var libro = Libro.from(command.getLibroId(), retrieveEvents(command.getLibroId().value()));

        libro.cambiarEspecialidadAutor(command.getAutorId(), command.getEspecialidad());

        emit().onResponse(new ResponseEvents(libro.getUncommittedChanges()));
        //libro.cambiarEspecialidadAutor();

    }
}
