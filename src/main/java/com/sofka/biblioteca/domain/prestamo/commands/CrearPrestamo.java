package com.sofka.biblioteca.domain.prestamo.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.biblioteca.domain.prestamo.values.FechaDevolucion;
import com.sofka.biblioteca.domain.prestamo.values.FechaPrestamo;
import com.sofka.biblioteca.domain.prestamo.values.PrestamoId;

public class CrearPrestamo extends Command {

    private final PrestamoId prestamoId;
    private final FechaPrestamo fechaPrestamo;
    private final FechaDevolucion fechaDevolucion;

    public CrearPrestamo(PrestamoId prestamoId, FechaPrestamo fechaPrestamo, FechaDevolucion fechaDevolucion){

        this.prestamoId = prestamoId;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public PrestamoId getPrestamoId() {
        return prestamoId;
    }

    public FechaPrestamo getFechaPrestamo() {
        return fechaPrestamo;
    }

    public FechaDevolucion getFechaDevolucion() {
        return fechaDevolucion;
    }
}
