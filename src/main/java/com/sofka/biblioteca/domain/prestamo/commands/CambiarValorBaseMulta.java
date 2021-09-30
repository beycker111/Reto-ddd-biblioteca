package com.sofka.biblioteca.domain.prestamo.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.biblioteca.domain.prestamo.values.PrestamoId;
import com.sofka.biblioteca.domain.prestamo.values.ValorBaseMulta;

public class CambiarValorBaseMulta extends Command {

    private final PrestamoId prestamoId;
    private final ValorBaseMulta valorBaseMulta;

    public CambiarValorBaseMulta(PrestamoId prestamoId, ValorBaseMulta valorBaseMulta){

        this.prestamoId = prestamoId;
        this.valorBaseMulta = valorBaseMulta;
    }

    public PrestamoId getPrestamoId() {
        return prestamoId;
    }

    public ValorBaseMulta getValorBaseMulta() {
        return valorBaseMulta;
    }
}
