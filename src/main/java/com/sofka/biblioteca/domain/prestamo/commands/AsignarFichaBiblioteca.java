package com.sofka.biblioteca.domain.prestamo.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.biblioteca.domain.prestamo.values.*;

public class AsignarFichaBiblioteca extends Command {

    private final PrestamoId prestamoId;
    private final FichaBibliotecaId fichaBibliotecaId;
    private final NombreBiblioteca nombreBiblioteca;
    private final NombreBibliotecario nombreBibliotecario;
    private final Observacion observacion;

    public AsignarFichaBiblioteca(PrestamoId prestamoId, FichaBibliotecaId fichaBibliotecaId,
                                  NombreBiblioteca nombreBiblioteca,
                                  NombreBibliotecario nombreBibliotecario,
                                  Observacion observacion){

        this.prestamoId = prestamoId;
        this.fichaBibliotecaId = fichaBibliotecaId;
        this.nombreBiblioteca = nombreBiblioteca;
        this.nombreBibliotecario = nombreBibliotecario;
        this.observacion = observacion;
    }

    public PrestamoId getPrestamoId() {
        return prestamoId;
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
