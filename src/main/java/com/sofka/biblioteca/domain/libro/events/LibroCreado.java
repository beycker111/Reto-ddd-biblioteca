package com.sofka.biblioteca.domain.libro.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.libro.values.Editorial;
import com.sofka.biblioteca.domain.libro.values.LibroId;
import com.sofka.biblioteca.domain.libro.values.Resumen;
import com.sofka.biblioteca.domain.shared.values.Nombre;

public class LibroCreado extends DomainEvent {

    private final Nombre nombre;
    private final Editorial editorial;
    private final Resumen resumen;

    public LibroCreado(Nombre nombre, Editorial editorial, Resumen resumen) {
        super("sofka.libro.librocreado");
        this.nombre = nombre;
        this.editorial = editorial;
        this.resumen = resumen;
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
