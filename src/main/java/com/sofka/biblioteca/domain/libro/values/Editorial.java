package com.sofka.biblioteca.domain.libro.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Editorial implements ValueObject<String> {
    private final String editorial;

    public Editorial(String editorial) {
        this.editorial = Objects.requireNonNull(editorial);
    }

    @Override
    public String value() {
        return editorial;
    }
}
