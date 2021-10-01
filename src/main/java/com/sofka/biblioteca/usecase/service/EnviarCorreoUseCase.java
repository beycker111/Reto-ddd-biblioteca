package com.sofka.biblioteca.usecase.service;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.biblioteca.domain.prestamo.events.MensajeEnviado;
import com.sofka.biblioteca.usecase.service.EnvioDeCorreoService;

public class EnviarCorreoUseCase extends UseCase<TriggeredEvent<MensajeEnviado>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<MensajeEnviado> mensajeEnviadoTriggeredEvent) {
        var event = mensajeEnviadoTriggeredEvent.getDomainEvent();
        var service = getService(EnvioDeCorreoService.class).orElseThrow();
        var isOk = service.enviarCorreo("adminbey@gmail.com", "Notificacion", event.getMensaje());

        if(!isOk){
            emit().onError(new BusinessException(
                    event.aggregateRootId(),
                    "No se pudo enviar el correo"
            ));
        }
    }
}
