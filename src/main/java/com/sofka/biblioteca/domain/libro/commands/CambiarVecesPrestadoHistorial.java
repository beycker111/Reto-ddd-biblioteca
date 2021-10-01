package com.sofka.biblioteca.domain.libro.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.biblioteca.domain.libro.values.HistorialId;
import com.sofka.biblioteca.domain.libro.values.LibroId;
import com.sofka.biblioteca.domain.libro.values.VecesPrestado;

public class CambiarVecesPrestadoHistorial extends Command {

    private final LibroId libroId;
    private final HistorialId historialId;
    private final VecesPrestado vecesPrestado;

    public CambiarVecesPrestadoHistorial(LibroId libroId, HistorialId historialId, VecesPrestado vecesPrestado){
        this.libroId = libroId;
        this.historialId = historialId;
        this.vecesPrestado = vecesPrestado;
    }

    public LibroId getLibroId() {
        return libroId;
    }

    public HistorialId getHistorialId() {
        return historialId;
    }

    public VecesPrestado getVecesPrestado() {
        return vecesPrestado;
    }
}
