package com.sofka.biblioteca.domain.libro.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.biblioteca.domain.libro.values.LibroId;
import com.sofka.biblioteca.domain.shared.values.Nombre;

public class CambiarNombre extends Command {

    private final LibroId libroId;
    private final Nombre nombre;

    public CambiarNombre(LibroId libroId, Nombre nombre){
        this.libroId = libroId;
        this.nombre = nombre;
    }

    public LibroId getLibroId() {
        return libroId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
