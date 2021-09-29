package com.sofka.biblioteca.domain.prestamo.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofka.biblioteca.domain.prestamo.values.LectorId;

public class Lector extends Entity<LectorId> {
    public Lector(LectorId entityId) {
        super(entityId);
    }
}
