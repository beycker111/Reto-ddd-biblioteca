package com.sofka.biblioteca.domain.prestamo.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.prestamo.values.NombreBibliotecario;

public class NombreBibliotecarioCambiado extends DomainEvent {
    private final NombreBibliotecario nombreBibliotecario;

    public NombreBibliotecarioCambiado(NombreBibliotecario nombreBibliotecario) {
        super("sofka.prestamo.nombrebibliotecariocambiado");
        this.nombreBibliotecario = nombreBibliotecario;
    }

    public NombreBibliotecario getNombreBibliotecario() {
        return nombreBibliotecario;
    }
}
