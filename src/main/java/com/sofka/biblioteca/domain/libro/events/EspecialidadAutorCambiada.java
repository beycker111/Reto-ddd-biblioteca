package com.sofka.biblioteca.domain.libro.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.libro.values.AutorId;
import com.sofka.biblioteca.domain.libro.values.Especialidad;

public class EspecialidadAutorCambiada extends DomainEvent {
    private final AutorId autorId;
    private final Especialidad especialidad;

    public EspecialidadAutorCambiada(AutorId autorId, Especialidad especialidad) {
        super("sofka.libro.especialidadautorcambiada");
        this.autorId = autorId;
        this.especialidad = especialidad;
    }

    public AutorId getAutorId() {
        return autorId;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }
}
