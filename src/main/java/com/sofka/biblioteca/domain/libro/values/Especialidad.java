package com.sofka.biblioteca.domain.libro.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Especialidad implements ValueObject<String> {
    private final String especialidad;

    public Especialidad(String especialidad) {
        this.especialidad = Objects.requireNonNull(especialidad);
    }

    @Override
    public String value() {
        return especialidad;
    }
}
