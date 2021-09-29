package com.sofka.biblioteca.domain.libro.values;

import co.com.sofka.domain.generic.Identity;

public class GeneroId extends Identity {

    public GeneroId(String id) {
        super(id);
    }

    public static GeneroId of(String id){
        return new GeneroId(id);
    }
}
