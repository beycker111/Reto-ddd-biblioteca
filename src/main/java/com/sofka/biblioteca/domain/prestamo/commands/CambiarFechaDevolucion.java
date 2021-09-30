package com.sofka.biblioteca.domain.prestamo.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.biblioteca.domain.prestamo.values.FechaDevolucion;
import com.sofka.biblioteca.domain.prestamo.values.PrestamoId;

public class CambiarFechaDevolucion extends Command {

    private final PrestamoId prestamoId;
    private final FechaDevolucion fechaDevolucion;

    public CambiarFechaDevolucion(PrestamoId prestamoId, FechaDevolucion fechaDevolucion){

        this.prestamoId = prestamoId;
        this.fechaDevolucion = fechaDevolucion;

    }

    public PrestamoId getPrestamoId() {
        return prestamoId;
    }

    public FechaDevolucion getFechaDevolucion() {
        return fechaDevolucion;
    }
}
