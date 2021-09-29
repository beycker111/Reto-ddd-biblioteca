package com.sofka.biblioteca.domain.prestamo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.util.Objects;

public class FechaDevolucion  implements ValueObject<LocalDate> {
    private final LocalDate fechaDevolucion;

    public FechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = Objects.requireNonNull(fechaDevolucion);
    }

    @Override
    public LocalDate value() {
        return fechaDevolucion;
    }
}
