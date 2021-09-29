package com.sofka.biblioteca.domain.libro.values;

import co.com.sofka.domain.generic.Identity;

public class HistorialId extends Identity {

    public HistorialId(String id) {
        super(id);
    }

    public static HistorialId of(String id){
        return new HistorialId(id);
    }
}
