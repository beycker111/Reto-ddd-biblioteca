package com.sofka.biblioteca.domain.libro.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.libro.values.Resumen;

public class ResumenCambiado extends DomainEvent {
    private final Resumen resumen;

    public ResumenCambiado(Resumen resumen) {
        super("sofka.libro.resumencambiado");
        this.resumen = resumen;
    }

    public Resumen getResumen() {
        return resumen;
    }
}
