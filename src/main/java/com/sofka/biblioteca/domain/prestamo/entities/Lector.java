package com.sofka.biblioteca.domain.prestamo.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofka.biblioteca.domain.prestamo.values.Email;
import com.sofka.biblioteca.domain.prestamo.values.LectorId;
import com.sofka.biblioteca.domain.prestamo.values.Telefono;
import com.sofka.biblioteca.domain.shared.values.Nombre;

public class Lector extends Entity<LectorId> {
    private Nombre nombre;
    private Telefono telefono;
    private Email email;

    public Lector(LectorId lectorId,
                  Nombre nombre,
                  Telefono telefono,
                  Email email) {
        super(lectorId);
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public void cambiarNombre(Nombre nombre){
        this.nombre = nombre;
    }

    public void cambiarTelefono(Telefono telefono){
        this.telefono = telefono;
    }

    public void cambiarEmail(Email email){
        this.email = email;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Telefono telefono() {
        return telefono;
    }

    public Email email() {
        return email;
    }
}
