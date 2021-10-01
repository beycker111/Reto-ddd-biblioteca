package com.sofka.biblioteca.domain.libro.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.libro.values.HistorialId;
import com.sofka.biblioteca.domain.libro.values.VecesPrestado;

public class VecesPrestadoIncrementado extends DomainEvent {
    private final HistorialId historialId;
    private final VecesPrestado vecesPrestado;

    public VecesPrestadoIncrementado(HistorialId historialId, VecesPrestado vecesPrestado) {
        super("sofka.libro.vecesprestadoincrementado");
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
