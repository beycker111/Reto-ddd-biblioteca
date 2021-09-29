package com.sofka.biblioteca.domain.libro.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.libro.values.AutorId;
import com.sofka.biblioteca.domain.libro.values.Especialidad;
import com.sofka.biblioteca.domain.shared.values.Nombre;

public class AutorAsignado extends DomainEvent {
    private final AutorId autorId;
    private final Nombre nombre;
    private final Especialidad especialidad;

    public AutorAsignado(AutorId autorId, Nombre nombre, Especialidad especialidad) {
        super("sofka.libro.autorasignado");
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
}
