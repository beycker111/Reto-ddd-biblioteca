package com.sofka.biblioteca.domain.libro.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofka.biblioteca.domain.libro.values.HistorialId;
import com.sofka.biblioteca.domain.libro.values.VecesPrestado;

public class Historial extends Entity<HistorialId> {

    private VecesPrestado vecesPrestado;

    public Historial(HistorialId historialId, VecesPrestado vecesPrestado) {
        super(historialId);
        this.vecesPrestado = vecesPrestado;
    }

    public void asignarVecesPrestado(VecesPrestado vecesPrestado){
        this.vecesPrestado = vecesPrestado;
    }

    public void incrementarPrestamos(){
        Integer incrementoPrestamos = this.vecesPrestado.value() + 1;
        this.vecesPrestado = new VecesPrestado(incrementoPrestamos);
    }

    public VecesPrestado vecesPrestado() {
        return vecesPrestado;
    }
}
