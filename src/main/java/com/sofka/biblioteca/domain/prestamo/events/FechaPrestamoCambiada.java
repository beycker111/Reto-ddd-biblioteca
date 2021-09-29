package com.sofka.biblioteca.domain.prestamo.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.prestamo.values.FechaPrestamo;

public class FechaPrestamoCambiada extends DomainEvent {
    private final FechaPrestamo fechaPrestamo;

    public FechaPrestamoCambiada(FechaPrestamo fechaPrestamo) {
        super("sofka.prestamo.fechaprestamocambiada");
        this.fechaPrestamo = fechaPrestamo;
    }

    public FechaPrestamo getFechaPrestamo() {
        return fechaPrestamo;
    }
}
