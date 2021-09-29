package com.sofka.biblioteca.domain.libro.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofka.biblioteca.domain.libro.values.AutorId;
import com.sofka.biblioteca.domain.libro.values.Especialidad;
import com.sofka.biblioteca.domain.shared.values.Nombre;

public class Autor extends Entity<AutorId> {

    private Nombre nombre;
    private Especialidad especialidad;

    public Autor(AutorId autorId, Nombre nombre, Especialidad especialidad) {
        super(autorId);
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public void cambiarNombre(Nombre nombre){
        this.nombre = nombre;
    }

    public void cambiarEspecialidad(Especialidad especialidad){
        this.especialidad = especialidad;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Especialidad especialidad() {
        return especialidad;
    }
}
