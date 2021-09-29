package com.sofka.biblioteca.domain.libro.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.libro.values.GeneroId;
import com.sofka.biblioteca.domain.libro.values.PublicoObjetivo;
import com.sofka.biblioteca.domain.shared.values.Nombre;

public class GeneroAsignado extends DomainEvent {
    private final GeneroId generoId;
    private final Nombre nombre;
    private final PublicoObjetivo publicoObjetivo;

    public GeneroAsignado(GeneroId generoId, Nombre nombre, PublicoObjetivo publicoObjetivo) {
        super("sofka.libro.generoasignado");
        this.generoId = generoId;
        this.nombre = nombre;
        this.publicoObjetivo = publicoObjetivo;
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
