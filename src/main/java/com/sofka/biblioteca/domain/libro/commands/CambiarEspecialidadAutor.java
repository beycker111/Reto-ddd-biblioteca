package com.sofka.biblioteca.domain.libro.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.biblioteca.domain.libro.values.Especialidad;
import com.sofka.biblioteca.domain.libro.values.LibroId;

public class CambiarEspecialidadAutor extends Command {

    private final LibroId libroId;
    private final Especialidad especialidad;

    public CambiarEspecialidadAutor(LibroId libroId, Especialidad especialidad){
        this.libroId = libroId;
        this.especialidad = especialidad;
    }

    public LibroId getLibroId() {
        return libroId;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }
}
