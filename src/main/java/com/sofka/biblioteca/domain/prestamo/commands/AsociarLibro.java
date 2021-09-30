package com.sofka.biblioteca.domain.prestamo.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.biblioteca.domain.libro.values.LibroId;
import com.sofka.biblioteca.domain.prestamo.values.PrestamoId;

public class AsociarLibro extends Command {

    private final PrestamoId prestamoId;
    private final LibroId libroId;

    public AsociarLibro(PrestamoId prestamoId, LibroId libroId){

        this.prestamoId = prestamoId;
        this.libroId = libroId;
    }

    public LibroId getLibroId() {
        return libroId;
    }

    public PrestamoId getPrestamoId() {
        return prestamoId;
    }
}
