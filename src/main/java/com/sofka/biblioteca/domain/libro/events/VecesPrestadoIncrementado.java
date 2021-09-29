package com.sofka.biblioteca.domain.libro.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.libro.values.VecesPrestado;

public class VecesPrestadoIncrementado extends DomainEvent {
    private final VecesPrestado vecesPrestado;

    public VecesPrestadoIncrementado(VecesPrestado vecesPrestado) {
        super("sofka.libro.vecesprestadoincrementado");
        this.vecesPrestado = vecesPrestado;
    }

    public VecesPrestado getVecesPrestado() {
        return vecesPrestado;
    }
}
