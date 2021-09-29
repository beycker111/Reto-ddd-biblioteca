package com.sofka.biblioteca.domain.libro.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.libro.values.Editorial;

public class EditorialCambiada extends DomainEvent {
    private final Editorial editorial;

    public EditorialCambiada(Editorial editorial) {
        super("sofka.libro.editorialcambiada");
        this.editorial = editorial;
    }

    public Editorial getEditorial() {
        return editorial;
    }
}
