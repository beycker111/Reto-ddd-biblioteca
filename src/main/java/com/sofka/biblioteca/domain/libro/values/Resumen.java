package com.sofka.biblioteca.domain.libro.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Resumen implements ValueObject<String> {
    private final String resumen;

    public Resumen(String resumen) {
        this.resumen = Objects.requireNonNull(resumen);
    }

    @Override
    public String value() {
        return resumen;
    }
}
