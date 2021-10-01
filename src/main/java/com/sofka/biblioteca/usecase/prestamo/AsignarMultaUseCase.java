package com.sofka.biblioteca.usecase.prestamo;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.biblioteca.domain.prestamo.Prestamo;
import com.sofka.biblioteca.domain.prestamo.commands.AsignarMulta;

public class AsignarMultaUseCase extends UseCase<RequestCommand<AsignarMulta>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsignarMulta> asignarMultaRequestCommand) {
        var command = asignarMultaRequestCommand.getCommand();
        var prestamo = Prestamo.from(command.getPrestamoId(), retrieveEvents(command.getPrestamoId().value()));

        prestamo.asignarMulta(command.getMultaId(),
                command.getDiasRetrasado(),
                command.getValorBaseMulta()
        );

        emit().onResponse(new ResponseEvents(prestamo.getUncommittedChanges()));
    }
}
