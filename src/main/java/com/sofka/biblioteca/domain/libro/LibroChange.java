package com.sofka.biblioteca.domain.libro;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.biblioteca.domain.libro.entities.Autor;
import com.sofka.biblioteca.domain.libro.entities.Genero;
import com.sofka.biblioteca.domain.libro.entities.Historial;
import com.sofka.biblioteca.domain.libro.events.*;

public class LibroChange extends EventChange {
    public LibroChange(Libro libro) {

        apply((LibroCreado event) -> {
            libro.nombre = event.getNombre();
            libro.editorial = event.getEditorial();
            libro.resumen = event.getResumen();
        });

        apply((HistorialAsignado event) -> {
            libro.historial = new Historial(
                event.getHistorialId(),
                event.getVecesPrestado()
            );
        });

        apply((GeneroAsignado event) -> {
            libro.genero = new Genero(
                    event.getGeneroId(),
                    event.getNombre(),
                    event.getPublicoObjetivo()
            );
        });

        apply((AutorAsignado event) -> {
            libro.autor = new Autor(
                    event.getAutorId(),
                    event.getNombre(),
                    event.getEspecialidad()
            );
        });

        apply((NombreCambiado event) -> {
            libro.nombre = event.getNombre();
        });

        apply((EditorialCambiada event) -> {
            libro.editorial = event.getEditorial();
        });

        apply((ResumenCambiado event) -> {
            libro.resumen = event.getResumen();
        });

        apply((VecesPrestadoCambiado event) -> {
            libro.historial.cambiarVecesPrestado(event.getVecesPrestado());
        });

        apply((VecesPrestadoIncrementado event) -> {
            libro.historial.incrementarPrestamos();
        });

        apply((EspecialidadAutorCambiada event) -> {
            libro.autor.cambiarEspecialidad(event.getEspecialidad());
        });
    }
}
