package com.sofka.biblioteca.domain.prestamo.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.prestamo.values.FechaDevolucion;

public class FechaDevolucionCambiada extends DomainEvent {
    private final FechaDevolucion fechaDevolucion;

    public FechaDevolucionCambiada(FechaDevolucion fechaDevolucion) {
        super("sofka.prestamo.fechadevolucioncambiada");
        this.fechaDevolucion = fechaDevolucion;
    }

    public FechaDevolucion getFechaDevolucion() {
        return fechaDevolucion;
    }
}
