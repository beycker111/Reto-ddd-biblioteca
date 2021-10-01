package com.sofka.biblioteca.domain.prestamo.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofka.biblioteca.domain.prestamo.values.FichaBibliotecaId;
import com.sofka.biblioteca.domain.prestamo.values.NombreBiblioteca;
import com.sofka.biblioteca.domain.prestamo.values.NombreBibliotecario;
import com.sofka.biblioteca.domain.prestamo.values.Observacion;

public class FichaBiblioteca extends Entity<FichaBibliotecaId> {

    private NombreBiblioteca nombreBiblioteca;
    private NombreBibliotecario nombreBibliotecario;
    private Observacion observacion;

    public FichaBiblioteca(FichaBibliotecaId fichaBibliotecaId,
                           NombreBiblioteca nombreBiblioteca,
                           NombreBibliotecario nombreBibliotecario,
                           Observacion observacion) {
        super(fichaBibliotecaId);
        this.nombreBiblioteca = nombreBiblioteca;
        this.nombreBibliotecario = nombreBibliotecario;
        this.observacion = observacion;
    }

    public void cambiarNombreBiblioteca(NombreBiblioteca nombreBiblioteca){
        this.nombreBiblioteca = nombreBiblioteca;
    }

    public void cambiarNombreBibliotecario(NombreBibliotecario nombreBibliotecario){
        this.nombreBibliotecario = nombreBibliotecario;
    }

    public void cambiarNombreObservaciones(Observacion observacion){
        this.observacion = observacion;
    }

    public NombreBiblioteca nombreBiblioteca() {
        return nombreBiblioteca;
    }

    public NombreBibliotecario nombreBibliotecario() {
        return nombreBibliotecario;
    }

    public Observacion observacion() {
        return observacion;
    }
}
