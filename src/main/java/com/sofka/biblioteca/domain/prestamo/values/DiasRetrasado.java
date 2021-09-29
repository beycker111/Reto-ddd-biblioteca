package com.sofka.biblioteca.domain.prestamo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.util.Objects;

public class DiasRetrasado implements ValueObject<Integer> {
    private final Integer diasRetrasado;

    public DiasRetrasado(Integer diasRetrasado) {
        this.diasRetrasado = Objects.requireNonNull(diasRetrasado);
    }


    @Override
    public Integer value() {
        return diasRetrasado;
    }
}
