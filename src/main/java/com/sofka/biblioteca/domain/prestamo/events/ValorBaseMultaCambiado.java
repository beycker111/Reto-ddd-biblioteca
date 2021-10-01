package com.sofka.biblioteca.domain.prestamo.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.prestamo.values.MultaId;
import com.sofka.biblioteca.domain.prestamo.values.ValorBaseMulta;

public class ValorBaseMultaCambiado extends DomainEvent {
    private final MultaId multaId;
    private final ValorBaseMulta valorBaseMulta;

    public ValorBaseMultaCambiado(MultaId multaId, ValorBaseMulta valorBaseMulta) {
        super("sofka.prestamo.valorbasemultacambiado");
        this.multaId = multaId;
        this.valorBaseMulta = valorBaseMulta;
    }

    public MultaId getMultaId() {
        return multaId;
    }

    public ValorBaseMulta getValorBaseMulta() {
        return valorBaseMulta;
    }
}
