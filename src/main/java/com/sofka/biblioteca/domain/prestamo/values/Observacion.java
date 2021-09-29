package com.sofka.biblioteca.domain.prestamo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Observacion implements ValueObject<String> {
    private final String observacion;

    public Observacion(String observacion) {
        this.observacion = Objects.requireNonNull(observacion);
    }

    @Override
    public String value() {
        return observacion;
    }
}
