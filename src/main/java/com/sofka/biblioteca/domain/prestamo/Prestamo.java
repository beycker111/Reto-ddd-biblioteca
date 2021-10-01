package com.sofka.biblioteca.domain.prestamo;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.biblioteca.domain.libro.values.LibroId;
import com.sofka.biblioteca.domain.prestamo.entities.FichaBiblioteca;
import com.sofka.biblioteca.domain.prestamo.entities.Lector;
import com.sofka.biblioteca.domain.prestamo.entities.Multa;
import com.sofka.biblioteca.domain.prestamo.events.*;
import com.sofka.biblioteca.domain.prestamo.values.*;
import com.sofka.biblioteca.domain.shared.values.Nombre;

import java.util.List;
import java.util.Objects;

public class Prestamo extends AggregateEvent<PrestamoId> {

    protected LibroId libroId;
    protected FechaPrestamo fechaPrestamo;
    protected FechaDevolucion fechaDevolucion;
    protected FichaBiblioteca fichaBiblioteca;
    protected Lector lector;
    protected Multa multa;

    public Prestamo(PrestamoId prestamoId, FechaPrestamo fechaPrestamo, FechaDevolucion fechaDevolucion){
        super(prestamoId);
        appendChange(new PrestamoCreado(fechaPrestamo, fechaDevolucion)).apply();
    }

    private Prestamo(PrestamoId prestamoId) {
        super(prestamoId);
        subscribe(new prestamoChange(this));
    }

    public static Prestamo from(PrestamoId prestamoId, List<DomainEvent> events){
        var prestamo = new Prestamo(prestamoId);
        events.forEach(prestamo::appendChange);
        return prestamo;
    }

    public void asociarLibro(LibroId libroId){
        appendChange(new LibroAsociado(libroId)).apply();
    }

    public void asignarFichaBiblioteca(FichaBibliotecaId fichaBibliotecaId,
                                       NombreBiblioteca nombreBiblioteca,
                                       NombreBibliotecario nombreBibliotecario,
                                       Observacion observacion){
        Objects.requireNonNull(fichaBibliotecaId);
        Objects.requireNonNull(nombreBiblioteca);
        Objects.requireNonNull(nombreBibliotecario);
        Objects.requireNonNull(observacion);

        appendChange(new FichaBibliotecaAsignada(fichaBibliotecaId, nombreBiblioteca, nombreBibliotecario, observacion)).apply();
    }

    public void asignarLector(LectorId lectorId,
                                       Nombre nombre,
                                       Telefono telefono,
                                       Email email){
        Objects.requireNonNull(lectorId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(telefono);
        Objects.requireNonNull(email);

        appendChange(new LectorAsignado(lectorId, nombre, telefono, email)).apply();
    }

    public void asignarMulta(MultaId multaId,
                              DiasRetrasado diasRetrasado,
                              ValorBaseMulta valorBaseMulta){
        Objects.requireNonNull(multaId);
        Objects.requireNonNull(diasRetrasado);
        Objects.requireNonNull(valorBaseMulta);

        appendChange(new MultaAsignada(multaId, diasRetrasado, valorBaseMulta)).apply();
    }

    public void cambiarFechaPrestamo(FechaPrestamo fechaPrestamo){
        Objects.requireNonNull(fechaPrestamo);
        appendChange(new FechaPrestamoCambiada(fechaPrestamo)).apply();
    }

    public void cambiarFechaDevolucion(FechaDevolucion fechaDevolucion){
        Objects.requireNonNull(fechaDevolucion);
        appendChange(new FechaDevolucionCambiada(fechaDevolucion)).apply();
    }

    public void cambiarNombreBiblioteca(FichaBibliotecaId fichaBibliotecaId, NombreBiblioteca nombreBiblioteca){
        Objects.requireNonNull(fichaBibliotecaId);
        Objects.requireNonNull(nombreBiblioteca);
        appendChange(new NombreBibliotecaCambiada(fichaBibliotecaId, nombreBiblioteca)).apply();
    }

    public void cambiarNombreBibliotecario(FichaBibliotecaId fichaBibliotecaId, NombreBibliotecario nombreBibliotecario){
        Objects.requireNonNull(fichaBibliotecaId);
        Objects.requireNonNull(nombreBibliotecario);
        appendChange(new NombreBibliotecarioCambiado(fichaBibliotecaId, nombreBibliotecario)).apply();
    }

    public void cambiarValorBaseMulta(MultaId multaId, ValorBaseMulta valorBaseMulta){
        Objects.requireNonNull(multaId);
        Objects.requireNonNull(valorBaseMulta);
        appendChange(new ValorBaseMultaCambiado(multaId, valorBaseMulta)).apply();
    }

    public LibroId libroId() {
        return libroId;
    }

    public FechaPrestamo fechaPrestamo() {
        return fechaPrestamo;
    }

    public FechaDevolucion fechaDevolucion() {
        return fechaDevolucion;
    }

    public FichaBiblioteca fichaBiblioteca() {
        return fichaBiblioteca;
    }

    public Lector lector() {
        return lector;
    }

    public Multa multa() {
        return multa;
    }

    public void enviarAlerta(String mensaje) {
        appendChange(new MensajeEnviado(mensaje)).apply();
    }
}
