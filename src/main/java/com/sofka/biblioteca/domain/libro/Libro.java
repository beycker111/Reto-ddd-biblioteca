package com.sofka.biblioteca.domain.libro;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.libro.entities.Autor;
import com.sofka.biblioteca.domain.libro.entities.Genero;
import com.sofka.biblioteca.domain.libro.entities.Historial;
import com.sofka.biblioteca.domain.libro.events.*;
import com.sofka.biblioteca.domain.libro.values.*;
import com.sofka.biblioteca.domain.shared.values.Nombre;

import java.util.List;
import java.util.Objects;

public class Libro extends AggregateEvent<LibroId> {

    protected Nombre nombre;
    protected Editorial editorial;
    protected Resumen resumen;
    protected Historial historial;
    protected Genero genero;
    protected Autor autor;

    public Libro(LibroId libroId, Nombre nombre, Editorial editorial, Resumen resumen){
        super(libroId);
        appendChange(new LibroCreado(nombre, editorial, resumen)).apply();
    }

    private Libro(LibroId libroId) {
        super(libroId);
        subscribe(new LibroChange(this));
    }

    public static Libro from(LibroId libroId, List<DomainEvent> events){
        var libro = new Libro(libroId);
        events.forEach(libro::applyEvent);
        return libro;
    }

    public void asignarHistorial(HistorialId historialId, VecesPrestado vecesPrestado){
        Objects.requireNonNull(historialId);
        Objects.requireNonNull(vecesPrestado);
        appendChange(new HistorialAsignado(historialId, vecesPrestado)).apply();
    }

    public void asignarGenero(GeneroId generoId, Nombre nombre, PublicoObjetivo publicoObjetivo){
        Objects.requireNonNull(generoId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(publicoObjetivo);
        appendChange(new GeneroAsignado(generoId, nombre, publicoObjetivo)).apply();
    }

    public void asignarAutor(AutorId autorId, Nombre nombre, Especialidad especialidad){
        Objects.requireNonNull(autorId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(especialidad);
        appendChange(new AutorAsignado(autorId, nombre, especialidad)).apply();
    }

    public void cambiarNombre(Nombre nombre){
        Objects.requireNonNull(nombre);
        appendChange(new NombreCambiado(nombre)).apply();
    }

    public void cambiarEditorial(Editorial editorial){
        Objects.requireNonNull(editorial);
        appendChange(new EditorialCambiada(editorial)).apply();
    }

    public void cambiarResumen(Resumen resumen){
        Objects.requireNonNull(resumen);
        appendChange(new ResumenCambiado(resumen)).apply();
    }

    public void cambiarVecesPrestadoHistorial(HistorialId historialId, VecesPrestado vecesPrestado){
        Objects.requireNonNull(vecesPrestado);
        appendChange(new VecesPrestadoCambiado(historialId, vecesPrestado)).apply();
    }

    public void incrementarVecesPrestadoHistorial(HistorialId historialId, VecesPrestado vecesPrestado){
        Objects.requireNonNull(vecesPrestado);
        appendChange(new VecesPrestadoIncrementado(historialId, vecesPrestado)).apply();
    }

    public void cambiarEspecialidadAutor(AutorId autorId, Especialidad especialidad){
        Objects.requireNonNull(especialidad);
        appendChange(new EspecialidadAutorCambiada(autorId, especialidad)).apply();
    }

    public Nombre nombre() {
        return nombre;
    }

    public Editorial editorial() {
        return editorial;
    }

    public Resumen resumen() {
        return resumen;
    }

    public Historial historial() {
        return historial;
    }

    public Genero genero() {
        return genero;
    }

    public Autor autor() {
        return autor;
    }
}
