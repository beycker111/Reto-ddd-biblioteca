package com.sofka.biblioteca.domain.libro.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class PublicoObjetivo implements ValueObject<String> {
    private final String publicoObjetivo;

    public PublicoObjetivo(String publicoObjetivo) {
        this.publicoObjetivo = Objects.requireNonNull(publicoObjetivo);
    }

    @Override
    public String value() {
        return publicoObjetivo;
    }
}
