package com.sofka.biblioteca.domain.prestamo.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.prestamo.values.FichaBibliotecaId;
import com.sofka.biblioteca.domain.prestamo.values.NombreBiblioteca;
import com.sofka.biblioteca.domain.prestamo.values.NombreBibliotecario;
import com.sofka.biblioteca.domain.prestamo.values.Observacion;

public class FichaBibliotecaAsignada extends DomainEvent {
    private final FichaBibliotecaId fichaBibliotecaId;
    private final NombreBiblioteca nombreBiblioteca;
    private final NombreBibliotecario nombreBibliotecario;
    private final Observacion observacion;

    public FichaBibliotecaAsignada(FichaBibliotecaId fichaBibliotecaId, NombreBiblioteca nombreBiblioteca, NombreBibliotecario nombreBibliotecario, Observacion observacion) {
        super("sofka.prestamo.fichabibliotecaasignada");
        this.fichaBibliotecaId = fichaBibliotecaId;
        this.nombreBiblioteca = nombreBiblioteca;
        this.nombreBibliotecario = nombreBibliotecario;
        this.observacion = observacion;
    }

    public FichaBibliotecaId getFichaBibliotecaId() {
        return fichaBibliotecaId;
    }

    public NombreBiblioteca getNombreBiblioteca() {
        return nombreBiblioteca;
    }

    public NombreBibliotecario getNombreBibliotecario() {
        return nombreBibliotecario;
    }

    public Observacion getObservacion() {
        return observacion;
    }
}
