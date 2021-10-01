package com.sofka.biblioteca.domain.prestamo.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.prestamo.values.FichaBibliotecaId;
import com.sofka.biblioteca.domain.prestamo.values.NombreBiblioteca;

public class NombreBibliotecaCambiada extends DomainEvent {
    private final FichaBibliotecaId fichaBibliotecaId;
    private final NombreBiblioteca nombreBiblioteca;

    public NombreBibliotecaCambiada(FichaBibliotecaId fichaBibliotecaId, NombreBiblioteca nombreBiblioteca) {
        super("sofka.prestamo.nombrebibliotecacambiada");
        this.fichaBibliotecaId = fichaBibliotecaId;
        this.nombreBiblioteca = nombreBiblioteca;
    }

    public FichaBibliotecaId getFichaBibliotecaId() {
        return fichaBibliotecaId;
    }

    public NombreBiblioteca getNombreBiblioteca() {
        return nombreBiblioteca;
    }
}
