package com.sofka.biblioteca.domain.prestamo.events;

import co.com.sofka.domain.generic.DomainEvent;

public class MensajeEnviado extends DomainEvent {
    private final String mensaje;

    public MensajeEnviado(String mensaje) {
        super("sofka.prestamo.mensajeenviado");
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
