package com.sofka.biblioteca.domain.libro.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.biblioteca.domain.libro.values.LibroId;
import com.sofka.biblioteca.domain.libro.values.VecesPrestado;

public class IncrementarVecesPrestadoHistorial extends Command {

    private final LibroId libroId;
    private final VecesPrestado vecesPrestado;

    public IncrementarVecesPrestadoHistorial(LibroId libroId, VecesPrestado vecesPrestado) {
        this.libroId = libroId;
        this.vecesPrestado = vecesPrestado;
    }

    public LibroId getLibroId() {
        return libroId;
    }

    public VecesPrestado getVecesPrestado() {
        return vecesPrestado;
    }
}
