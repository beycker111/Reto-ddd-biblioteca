package com.sofka.biblioteca.domain.libro.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.biblioteca.domain.libro.values.Editorial;
import com.sofka.biblioteca.domain.libro.values.LibroId;

public class CambiarEditorial extends Command {

    private final LibroId libroId;
    private final Editorial editorial;

    public CambiarEditorial(LibroId libroId, Editorial editorial){
        this.libroId = libroId;
        this.editorial = editorial;
    }

    public LibroId getLibroId() {
        return libroId;
    }

    public Editorial getEditorial() {
        return editorial;
    }
}
