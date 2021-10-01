package com.sofka.biblioteca.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.biblioteca.domain.libro.Libro;
import com.sofka.biblioteca.domain.libro.commands.AsignarAutor;
import com.sofka.biblioteca.domain.libro.entities.Autor;
import com.sofka.biblioteca.domain.libro.values.Editorial;
import com.sofka.biblioteca.domain.libro.values.LibroId;
import com.sofka.biblioteca.domain.libro.values.Resumen;
import com.sofka.biblioteca.domain.shared.values.Nombre;

public class AsignarAutorUseCase extends UseCase<RequestCommand<AsignarAutor>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsignarAutor> asignarAutorRequestCommand) {
        var command = asignarAutorRequestCommand.getCommand();
        var libro = Libro.from(command.getLibroId(), retrieveEvents(command.getLibroId().value()));

        libro.asignarAutor(command.getAutorId(),
                command.getNombre(),
                command.getEspecialidad()
        );

        emit().onResponse(new ResponseEvents(libro.getUncommittedChanges()));
    }
}
