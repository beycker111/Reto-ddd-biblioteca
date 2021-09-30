package com.sofka.biblioteca.domain.libro.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.biblioteca.domain.libro.values.Editorial;
import com.sofka.biblioteca.domain.libro.values.LibroId;
import com.sofka.biblioteca.domain.libro.values.Resumen;
import com.sofka.biblioteca.domain.shared.values.Nombre;

public class CrearLibro extends Command {

    private final LibroId libroId;
    private final Nombre nombre;
    private final Editorial editorial;
    private final Resumen resumen;

    public CrearLibro(LibroId libroId, Nombre nombre, Editorial editorial, Resumen resumen){

        this.libroId = libroId;
        this.nombre = nombre;
        this.editorial = editorial;
        this.resumen = resumen;
    }

    public LibroId getLibroId() {
        return libroId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public Resumen getResumen() {
        return resumen;
    }
}
