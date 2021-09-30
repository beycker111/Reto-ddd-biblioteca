package com.sofka.biblioteca.domain.libro.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.biblioteca.domain.libro.values.LibroId;
import com.sofka.biblioteca.domain.libro.values.Resumen;

public class CambiarResumen extends Command {

    private final LibroId libroId;
    private final Resumen resumen;

    public CambiarResumen(LibroId libroId, Resumen resumen){
        this.libroId = libroId;
        this.resumen = resumen;
    }

    public LibroId getLibroId() {
        return libroId;
    }

    public Resumen getResumen() {
        return resumen;
    }
}
