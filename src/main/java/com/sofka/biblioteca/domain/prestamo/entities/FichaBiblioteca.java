package com.sofka.biblioteca.domain.prestamo.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofka.biblioteca.domain.prestamo.values.FichaBibliotecaId;

public class FichaBiblioteca extends Entity<FichaBibliotecaId> {
    public FichaBiblioteca(FichaBibliotecaId entityId) {
        super(entityId);
    }
}
