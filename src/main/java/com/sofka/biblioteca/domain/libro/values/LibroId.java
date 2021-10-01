package com.sofka.biblioteca.domain.libro.values;

import co.com.sofka.domain.generic.Identity;

import java.util.UUID;

public class LibroId extends Identity {

    public LibroId(String id) {
        super(id);
    }

    public static LibroId of(String id){
        return new LibroId(id);
    }
}
