package com.sofka.biblioteca.domain.libro.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.biblioteca.domain.libro.values.AutorId;
import com.sofka.biblioteca.domain.libro.values.Especialidad;
import com.sofka.biblioteca.domain.libro.values.LibroId;
import com.sofka.biblioteca.domain.shared.values.Nombre;

public class AsignarAutor extends Command {

    private final LibroId libroId;
    private final AutorId autorId;
    private final Nombre nombre;
    private final Especialidad especialidad;

    public AsignarAutor(LibroId libroId, AutorId autorId, Nombre nombre, Especialidad especialidad){
        this.libroId = libroId;
        this.autorId = autorId;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public AutorId getAutorId() {
        return autorId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public LibroId getLibroId() {
        return libroId;
    }
}
