package com.sofka.biblioteca.domain.libro.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.libro.values.VecesPrestado;

public class VecesPrestadoAsignado extends DomainEvent {
    private final VecesPrestado vecesPrestado;

    public VecesPrestadoAsignado(VecesPrestado vecesPrestado) {
        super("sofka.libro.vecesprestadoasignado");
        this.vecesPrestado = vecesPrestado;
    }

    public VecesPrestado getVecesPrestado() {
        return vecesPrestado;
    }
}
