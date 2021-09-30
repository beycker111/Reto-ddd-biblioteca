package com.sofka.biblioteca.domain.prestamo.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.biblioteca.domain.prestamo.values.NombreBiblioteca;
import com.sofka.biblioteca.domain.prestamo.values.PrestamoId;

public class CambiarNombreBiblioteca extends Command {

    private final PrestamoId prestamoId;
    private final NombreBiblioteca nombreBiblioteca;

    public CambiarNombreBiblioteca(PrestamoId prestamoId, NombreBiblioteca nombreBiblioteca){

        this.prestamoId = prestamoId;
        this.nombreBiblioteca = nombreBiblioteca;
    }

    public PrestamoId getPrestamoId() {
        return prestamoId;
    }

    public NombreBiblioteca getNombreBiblioteca() {
        return nombreBiblioteca;
    }
}
