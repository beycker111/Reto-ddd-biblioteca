package com.sofka.biblioteca.domain.prestamo.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.prestamo.values.ValorBaseMulta;

public class ValorBaseMultaCambiado extends DomainEvent {
    private final ValorBaseMulta valorBaseMulta;

    public ValorBaseMultaCambiado(ValorBaseMulta valorBaseMulta) {
        super("sofka.prestamo.valorbasemultacambiado");
        this.valorBaseMulta = valorBaseMulta;
    }

    public ValorBaseMulta getValorBaseMulta() {
        return valorBaseMulta;
    }
}
