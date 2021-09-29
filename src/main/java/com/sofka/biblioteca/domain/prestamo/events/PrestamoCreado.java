package com.sofka.biblioteca.domain.prestamo.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.prestamo.values.FechaDevolucion;
import com.sofka.biblioteca.domain.prestamo.values.FechaPrestamo;

public class PrestamoCreado extends DomainEvent {
    private final FechaPrestamo fechaPrestamo;
    private final FechaDevolucion fechaDevolucion;

    public PrestamoCreado(FechaPrestamo fechaPrestamo, FechaDevolucion fechaDevolucion) {
        super("sofka.prestamo.prestamocreado");
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public FechaPrestamo getFechaPrestamo() {
        return fechaPrestamo;
    }

    public FechaDevolucion getFechaDevolucion() {
        return fechaDevolucion;
    }
}
