package com.sofka.biblioteca.domain.prestamo.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.biblioteca.domain.prestamo.values.FichaBibliotecaId;
import com.sofka.biblioteca.domain.prestamo.values.NombreBibliotecario;
import com.sofka.biblioteca.domain.prestamo.values.PrestamoId;

public class CambiarNombreBibliotecario extends Command {

    private final PrestamoId prestamoId;
    private final FichaBibliotecaId fichaBibliotecaId;
    private final NombreBibliotecario nombreBibliotecario;

    public CambiarNombreBibliotecario(PrestamoId prestamoId, FichaBibliotecaId fichaBibliotecaId, NombreBibliotecario nombreBibliotecario){

        this.prestamoId = prestamoId;
        this.fichaBibliotecaId = fichaBibliotecaId;
        this.nombreBibliotecario = nombreBibliotecario;
    }

    public PrestamoId getPrestamoId() {
        return prestamoId;
    }

    public FichaBibliotecaId getFichaBibliotecaId() {
        return fichaBibliotecaId;
    }

    public NombreBibliotecario getNombreBibliotecario() {
        return nombreBibliotecario;
    }
}
