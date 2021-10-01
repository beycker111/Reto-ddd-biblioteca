package com.sofka.biblioteca.domain.prestamo.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.prestamo.values.FichaBibliotecaId;
import com.sofka.biblioteca.domain.prestamo.values.NombreBibliotecario;

public class NombreBibliotecarioCambiado extends DomainEvent {
    private final FichaBibliotecaId fichaBibliotecaId;
    private final NombreBibliotecario nombreBibliotecario;

    public NombreBibliotecarioCambiado(FichaBibliotecaId fichaBibliotecaId, NombreBibliotecario nombreBibliotecario) {
        super("sofka.prestamo.nombrebibliotecariocambiado");
        this.fichaBibliotecaId = fichaBibliotecaId;
        this.nombreBibliotecario = nombreBibliotecario;
    }

    public FichaBibliotecaId getFichaBibliotecaId() {
        return fichaBibliotecaId;
    }

    public NombreBibliotecario getNombreBibliotecario() {
        return nombreBibliotecario;
    }
}
