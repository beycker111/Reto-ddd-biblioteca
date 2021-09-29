package com.sofka.biblioteca.domain.libro.values;

import co.com.sofka.domain.generic.Identity;

public class AutorId extends Identity {

    public AutorId(String id) {
        super(id);
    }

    public static AutorId of(String id){
        return new AutorId(id);
    }
}
