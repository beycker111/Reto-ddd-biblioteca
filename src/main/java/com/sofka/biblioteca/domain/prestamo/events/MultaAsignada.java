package com.sofka.biblioteca.domain.prestamo.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.prestamo.values.DiasRetrasado;
import com.sofka.biblioteca.domain.prestamo.values.MultaId;
import com.sofka.biblioteca.domain.prestamo.values.ValorBaseMulta;

public class MultaAsignada extends DomainEvent {
    private final MultaId multaId;
    private final DiasRetrasado diasRetrasado;
    private final ValorBaseMulta valorBaseMulta;

    public MultaAsignada(MultaId multaId, DiasRetrasado diasRetrasado, ValorBaseMulta valorBaseMulta) {
        super("sofka.prestamo.multaasignada");
        this.multaId = multaId;
        this.diasRetrasado = diasRetrasado;
        this.valorBaseMulta = valorBaseMulta;
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
