package com.sofka.biblioteca.domain.prestamo.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.biblioteca.domain.prestamo.values.DiasRetrasado;
import com.sofka.biblioteca.domain.prestamo.values.MultaId;
import com.sofka.biblioteca.domain.prestamo.values.PrestamoId;
import com.sofka.biblioteca.domain.prestamo.values.ValorBaseMulta;

public class AsignarMulta extends Command {

    private final PrestamoId prestamoId;
    private final MultaId multaId;
    private final DiasRetrasado diasRetrasado;
    private final ValorBaseMulta valorBaseMulta;

    public AsignarMulta(PrestamoId prestamoId, MultaId multaId,
                        DiasRetrasado diasRetrasado,
                        ValorBaseMulta valorBaseMulta){

        this.prestamoId = prestamoId;
        this.multaId = multaId;
        this.diasRetrasado = diasRetrasado;
        this.valorBaseMulta = valorBaseMulta;
    }

    public PrestamoId getPrestamoId() {
        return prestamoId;
    }

    public MultaId getMultaId() {
        return multaId;
    }

    public DiasRetrasado getDiasRetrasado() {
        return diasRetrasado;
    }

    public ValorBaseMulta getValorBaseMulta() {
        return valorBaseMulta;
    }
}
