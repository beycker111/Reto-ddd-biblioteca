package com.sofka.biblioteca.domain.prestamo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ValorBaseMulta implements ValueObject<Integer> {
    private final Integer valorBaseMulta;

    public ValorBaseMulta(Integer valorBaseMulta) {
        this.valorBaseMulta = Objects.requireNonNull(valorBaseMulta);
    }

    @Override
    public Integer value() {
        return valorBaseMulta;
    }
}
