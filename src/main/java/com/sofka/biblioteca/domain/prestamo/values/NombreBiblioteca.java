package com.sofka.biblioteca.domain.prestamo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreBiblioteca implements ValueObject<String> {
    private final String nombreBiblioteca;

    public NombreBiblioteca(String nombreBiblioteca) {
        this.nombreBiblioteca = Objects.requireNonNull(nombreBiblioteca);
    }

    @Override
    public String value() {
        return nombreBiblioteca;
    }
}
