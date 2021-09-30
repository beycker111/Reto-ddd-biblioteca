package com.sofka.biblioteca.domain.prestamo.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.biblioteca.domain.prestamo.values.NombreBibliotecario;
import com.sofka.biblioteca.domain.prestamo.values.PrestamoId;

public class CambiarNombreBibliotecario extends Command {

    private final PrestamoId prestamoId;
    private final NombreBibliotecario nombreBibliotecario;

    public CambiarNombreBibliotecario(PrestamoId prestamoId, NombreBibliotecario nombreBibliotecario){

        this.prestamoId = prestamoId;
        this.nombreBibliotecario = nombreBibliotecario;
    }

    public PrestamoId getPrestamoId() {
        return prestamoId;
    }

    public NombreBibliotecario getNombreBibliotecario() {
        return nombreBibliotecario;
    }
}
