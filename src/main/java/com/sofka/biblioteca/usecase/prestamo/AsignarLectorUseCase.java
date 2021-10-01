package com.sofka.biblioteca.usecase.prestamo;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.biblioteca.domain.prestamo.Prestamo;
import com.sofka.biblioteca.domain.prestamo.commands.AsignarLector;

public class AsignarLectorUseCase extends UseCase<RequestCommand<AsignarLector>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsignarLector> asignarLectorRequestCommand) {
        var command = asignarLectorRequestCommand.getCommand();
        var prestamo = Prestamo.from(command.getPrestamoId(), retrieveEvents(command.getPrestamoId().value()));

        prestamo.asignarLector(command.getLectorId(),
                command.getNombre(),
                command.getTelefono(),
                command.getEmail());

        emit().onResponse(new ResponseEvents(prestamo.getUncommittedChanges()));
    }
}
