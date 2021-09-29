package com.sofka.biblioteca.domain.prestamo.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.prestamo.values.Email;
import com.sofka.biblioteca.domain.prestamo.values.LectorId;
import com.sofka.biblioteca.domain.prestamo.values.Telefono;
import com.sofka.biblioteca.domain.shared.values.Nombre;

public class LectorAsignado extends DomainEvent {
    private final LectorId lectorId;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Email email;

    public LectorAsignado(LectorId lectorId, Nombre nombre, Telefono telefono, Email email) {
        super("sofka.prestamo.lectorasignado");
        this.lectorId = lectorId;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public LectorId getLectorId() {
        return lectorId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public Email getEmail() {
        return email;
    }
}
