package com.sofka.biblioteca.domain.libro.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class VecesPrestado implements ValueObject<Integer> {
    private final Integer vecesPrestado;

    public VecesPrestado(Integer vecesPrestado) {
        this.vecesPrestado = Objects.requireNonNull(vecesPrestado);
    }

    @Override
    public Integer value() {
        return vecesPrestado;
    }
}
