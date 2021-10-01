package com.sofka.biblioteca.domain.libro.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.biblioteca.domain.libro.values.AutorId;
import com.sofka.biblioteca.domain.libro.values.Especialidad;
import com.sofka.biblioteca.domain.libro.values.LibroId;

public class CambiarEspecialidadAutor extends Command {

    private final LibroId libroId;
    private final AutorId autorId;
    private final Especialidad especialidad;

    public CambiarEspecialidadAutor(LibroId libroId, AutorId autorId, Especialidad especialidad){
        this.libroId = libroId;
        this.autorId = autorId;
        this.especialidad = especialidad;
    }

    public LibroId getLibroId() {
        return libroId;
    }

    public AutorId getAutorId() {
        return autorId;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }
}
