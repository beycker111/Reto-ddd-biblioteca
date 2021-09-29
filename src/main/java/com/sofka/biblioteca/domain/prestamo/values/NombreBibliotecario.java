package com.sofka.biblioteca.domain.prestamo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreBibliotecario implements ValueObject<String> {
    private final String nombreBibliotecario;

    public NombreBibliotecario(String nombreBibliotecario) {
        this.nombreBibliotecario = Objects.requireNonNull(nombreBibliotecario);
    }

    @Override
    public String value() {
        return nombreBibliotecario;
    }
}
