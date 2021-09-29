package com.sofka.biblioteca.domain.libro.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.libro.values.Especialidad;

public class EspecialidadAutorCambiada extends DomainEvent {
    private final Especialidad especialidad;

    public EspecialidadAutorCambiada(Especialidad especialidad) {
        super("sofka.libro.especialidadautorcambiada");
        this.especialidad = especialidad;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }
}
