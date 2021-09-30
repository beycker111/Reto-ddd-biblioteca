package com.sofka.biblioteca.domain.libro.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.biblioteca.domain.libro.values.GeneroId;
import com.sofka.biblioteca.domain.libro.values.LibroId;
import com.sofka.biblioteca.domain.libro.values.PublicoObjetivo;
import com.sofka.biblioteca.domain.shared.values.Nombre;

public class AsignarGenero extends Command {

    private final LibroId libroId;
    private final GeneroId generoId;
    private final Nombre nombre;
    private final PublicoObjetivo publicoObjetivo;

    public AsignarGenero(LibroId libroId, GeneroId generoId, Nombre nombre, PublicoObjetivo publicoObjetivo){
        this.libroId = libroId;
        this.generoId = generoId;
        this.nombre = nombre;
        this.publicoObjetivo = publicoObjetivo;
    }

    public LibroId getLibroId() {
        return libroId;
    }

    public GeneroId getGeneroId() {
        return generoId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public PublicoObjetivo getPublicoObjetivo() {
        return publicoObjetivo;
    }
}
