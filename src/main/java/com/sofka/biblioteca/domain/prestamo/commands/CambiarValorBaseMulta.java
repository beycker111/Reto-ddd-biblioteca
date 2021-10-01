package com.sofka.biblioteca.domain.prestamo.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.biblioteca.domain.prestamo.values.MultaId;
import com.sofka.biblioteca.domain.prestamo.values.PrestamoId;
import com.sofka.biblioteca.domain.prestamo.values.ValorBaseMulta;

public class CambiarValorBaseMulta extends Command {

    private final PrestamoId prestamoId;
    private final MultaId multaId;
    private final ValorBaseMulta valorBaseMulta;

    public CambiarValorBaseMulta(PrestamoId prestamoId, MultaId multaId, ValorBaseMulta valorBaseMulta){

        this.prestamoId = prestamoId;
        this.multaId = multaId;
        this.valorBaseMulta = valorBaseMulta;
    }

    public PrestamoId getPrestamoId() {
        return prestamoId;
    }

    public MultaId getMultaId() {
        return multaId;
    }

    public ValorBaseMulta getValorBaseMulta() {
        return valorBaseMulta;
    }
}
