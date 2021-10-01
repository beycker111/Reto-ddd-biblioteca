package com.sofka.biblioteca.domain.libro.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.libro.values.HistorialId;
import com.sofka.biblioteca.domain.libro.values.VecesPrestado;

public class VecesPrestadoCambiado extends DomainEvent {
    private final HistorialId historialId;
    private final VecesPrestado vecesPrestado;

    public VecesPrestadoCambiado(HistorialId historialId, VecesPrestado vecesPrestado) {
        super("sofka.libro.vecesprestadoasignado");
        this.historialId = historialId;
        this.vecesPrestado = vecesPrestado;
    }

    public HistorialId getHistorialId() {
        return historialId;
    }

    public VecesPrestado getVecesPrestado() {
        return vecesPrestado;
    }
}
