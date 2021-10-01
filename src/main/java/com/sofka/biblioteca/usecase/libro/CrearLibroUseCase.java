package com.sofka.biblioteca.usecase.libro;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.biblioteca.domain.libro.Libro;
import com.sofka.biblioteca.domain.libro.commands.CrearLibro;

public class CrearLibroUseCase extends UseCase<RequestCommand<CrearLibro>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<CrearLibro> crearLibroRequestCommand) {
        var command =crearLibroRequestCommand.getCommand();

        Libro libro;

        libro = new Libro(
                command.getLibroId(),
                command.getNombre(),
                command.getEditorial(),
                command.getResumen()
        );

        emit().onResponse(new ResponseEvents(libro.getUncommittedChanges()));
    }
}
