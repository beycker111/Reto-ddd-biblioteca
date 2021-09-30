package com.sofka.biblioteca.domain.prestamo.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.biblioteca.domain.prestamo.values.Email;
import com.sofka.biblioteca.domain.prestamo.values.LectorId;
import com.sofka.biblioteca.domain.prestamo.values.PrestamoId;
import com.sofka.biblioteca.domain.prestamo.values.Telefono;
import com.sofka.biblioteca.domain.shared.values.Nombre;

public class AsignarLector extends Command {

    private final PrestamoId prestamoId;
    private final LectorId lectorId;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Email email;

    public AsignarLector(PrestamoId prestamoId, LectorId lectorId, Nombre nombre, Telefono telefono, Email email){
        this.prestamoId = prestamoId;
        this.lectorId = lectorId;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public PrestamoId getPrestamoId() {
        return prestamoId;
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
