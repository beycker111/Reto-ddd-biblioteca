package com.sofka.biblioteca.domain.prestamo.values;

import co.com.sofka.domain.generic.Identity;

public class LectorId extends Identity {

    public LectorId(String id) {
        super(id);
    }

    public static LectorId of(String id){
        return new LectorId(id);
    }
}
