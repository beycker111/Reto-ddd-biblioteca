package com.sofka.biblioteca.domain.prestamo;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.biblioteca.domain.prestamo.entities.FichaBiblioteca;
import com.sofka.biblioteca.domain.prestamo.entities.Lector;
import com.sofka.biblioteca.domain.prestamo.entities.Multa;
import com.sofka.biblioteca.domain.prestamo.events.*;

public class prestamoChange extends EventChange {

    public prestamoChange(Prestamo prestamo) {

        apply((PrestamoCreado event) -> {
            prestamo.fechaPrestamo = event.getFechaPrestamo();
            prestamo.fechaDevolucion = event.getFechaDevolucion();
        });

        apply((LibroAsociado event) -> {
            prestamo.libroId = event.getLibroId();
        });

        apply((FichaBibliotecaAsignada event) -> {
            prestamo.fichaBiblioteca = new FichaBiblioteca(
                    event.getFichaBibliotecaId(),
                    event.getNombreBiblioteca(),
                    event.getNombreBibliotecario(),
                    event.getObservacion()
            );
        });

        apply((LectorAsignado event) -> {
            prestamo.lector = new Lector(
                    event.getLectorId(),
                    event.getNombre(),
                    event.getTelefono(),
                    event.getEmail()
            );
        });

        apply((MultaAsignada event) -> {
            prestamo.multa = new Multa(
                    event.getMultaId(),
                    event.getDiasRetrasado(),
                    event.getValorBaseMulta()
            );
        });

        apply((FechaPrestamoCambiada event) -> {
            prestamo.fechaPrestamo = event.getFechaPrestamo();
        });

        apply((FechaDevolucionCambiada event) -> {
            prestamo.fechaDevolucion = event.getFechaDevolucion();
        });

        apply((NombreBibliotecaCambiada event) -> {
            prestamo.fichaBiblioteca.cambiarNombreBiblioteca(event.getNombreBiblioteca());
        });

        apply((NombreBibliotecarioCambiado event) -> {
            prestamo.fichaBiblioteca.cambiarNombreBibliotecario(event.getNombreBibliotecario());
        });

        apply((ValorBaseMultaCambiado event) -> {
            prestamo.multa.cambiarValorBaseMulta(event.getValorBaseMulta());
        });
    }
}
