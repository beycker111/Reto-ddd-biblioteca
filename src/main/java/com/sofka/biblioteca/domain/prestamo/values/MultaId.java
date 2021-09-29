package com.sofka.biblioteca.domain.prestamo.values;

import co.com.sofka.domain.generic.Identity;

public class MultaId extends Identity {

    public MultaId(String id) {
        super(id);
    }

    public static MultaId of(String id){
        return new MultaId(id);
    }
}
