package com.sofka.biblioteca.domain.prestamo.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.prestamo.values.NombreBiblioteca;

public class NombreBibliotecaCambiada extends DomainEvent {
    private final NombreBiblioteca nombreBiblioteca;

    public NombreBibliotecaCambiada(NombreBiblioteca nombreBiblioteca) {
        super("sofka.prestamo.nombrebibliotecacambiada");
        this.nombreBiblioteca = nombreBiblioteca;
    }

    public NombreBiblioteca getNombreBiblioteca() {
        return nombreBiblioteca;
    }
}
