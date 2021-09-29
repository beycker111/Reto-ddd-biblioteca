package com.sofka.biblioteca.domain.prestamo.values;

import co.com.sofka.domain.generic.Identity;

public class FichaBibliotecaId extends Identity {

    public FichaBibliotecaId(String id) {
        super(id);
    }

    public static FichaBibliotecaId of(String id){
        return new FichaBibliotecaId(id);
    }
}
