package com.sofka.biblioteca.domain.prestamo.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.biblioteca.domain.prestamo.values.FechaPrestamo;
import com.sofka.biblioteca.domain.prestamo.values.PrestamoId;

public class CambiarFechaPrestamo extends Command {

    private final PrestamoId prestamoId;
    private final FechaPrestamo fechaPrestamo;

    public CambiarFechaPrestamo(PrestamoId prestamoId, FechaPrestamo fechaPrestamo){

        this.prestamoId = prestamoId;
        this.fechaPrestamo = fechaPrestamo;
    }

    public PrestamoId getPrestamoId() {
        return prestamoId;
    }

    public FechaPrestamo getFechaPrestamo() {
        return fechaPrestamo;
    }
}
