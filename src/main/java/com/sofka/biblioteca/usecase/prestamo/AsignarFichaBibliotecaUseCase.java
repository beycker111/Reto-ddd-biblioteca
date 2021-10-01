package com.sofka.biblioteca.usecase.prestamo;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.biblioteca.domain.prestamo.Prestamo;
import com.sofka.biblioteca.domain.prestamo.commands.AsignarFichaBiblioteca;

public class AsignarFichaBibliotecaUseCase extends UseCase<RequestCommand<AsignarFichaBiblioteca>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsignarFichaBiblioteca> asignarFichaBibliotecaRequestCommand) {
        var command = asignarFichaBibliotecaRequestCommand.getCommand();
        var prestamo = Prestamo.from(command.getPrestamoId(), retrieveEvents(command.getPrestamoId().value()));

        prestamo.asignarFichaBiblioteca(command.getFichaBibliotecaId(),
                command.getNombreBiblioteca(),
                command.getNombreBibliotecario(),
                command.getObservacion());

        emit().onResponse(new ResponseEvents(prestamo.getUncommittedChanges()));
    }
}
