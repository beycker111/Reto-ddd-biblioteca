package com.sofka.biblioteca.domain.prestamo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.util.Objects;

public class FechaPrestamo implements ValueObject<LocalDate> {
    private final LocalDate fechaPrestamo;

    public FechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = Objects.requireNonNull(fechaPrestamo);
    }

    @Override
    public LocalDate value() {
        return fechaPrestamo;
    }
}
