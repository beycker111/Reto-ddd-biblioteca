package com.sofka.biblioteca.domain.libro.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofka.biblioteca.domain.libro.values.GeneroId;
import com.sofka.biblioteca.domain.libro.values.PublicoObjetivo;
import com.sofka.biblioteca.domain.shared.values.Nombre;

public class Genero extends Entity<GeneroId> {

    private Nombre nombre;
    private PublicoObjetivo publicoObjetivo;

    public Genero(GeneroId generoId, Nombre nombre, PublicoObjetivo publicoObjetivo) {
        super(generoId);
        this.nombre = nombre;
        this.publicoObjetivo = publicoObjetivo;
    }

    public void cambiarNombre(Nombre nombre){
        this.nombre = nombre;
    }

    public void cambiarPublicoObjetivo(PublicoObjetivo publicoObjetivo){
        this.publicoObjetivo = publicoObjetivo;
    }

    public Nombre nombre() {
        return nombre;
    }

    public PublicoObjetivo publicoObjetivo() {
        return publicoObjetivo;
    }
}
