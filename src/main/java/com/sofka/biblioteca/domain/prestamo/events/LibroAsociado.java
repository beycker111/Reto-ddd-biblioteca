package com.sofka.biblioteca.domain.prestamo.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.libro.values.LibroId;

public class LibroAsociado extends DomainEvent {
    private final LibroId libroId;

    public LibroAsociado(LibroId libroId) {
        super("sofka.prestamo.libroasociado");
        this.libroId = libroId;
    }

    public LibroId getLibroId() {
        return libroId;
    }
}
