package com.sofka.biblioteca.domain.prestamo.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofka.biblioteca.domain.prestamo.values.DiasRetrasado;
import com.sofka.biblioteca.domain.prestamo.values.MultaId;
import com.sofka.biblioteca.domain.prestamo.values.ValorBaseMulta;

public class Multa extends Entity<MultaId> {

    private DiasRetrasado diasRetrasado;
    private ValorBaseMulta valorBaseMulta;

    public Multa(MultaId multaId,
                 DiasRetrasado diasRetrasado,
                 ValorBaseMulta valorBaseMulta) {
        super(multaId);
        this.diasRetrasado = diasRetrasado;
        this.valorBaseMulta = valorBaseMulta;
    }

    public Integer generarMulta(){
        return this.diasRetrasado.value() * this.valorBaseMulta.value();
    }

    public void colocarRetraso(DiasRetrasado diasRetrasado){
        this.diasRetrasado = diasRetrasado;
    }

    public void cambiarValorBaseMulta(ValorBaseMulta valorBaseMulta){
        this.valorBaseMulta = valorBaseMulta;
    }

    public DiasRetrasado getDiasRetrasado() {
        return diasRetrasado;
    }

    public ValorBaseMulta getValorBaseMulta() {
        return valorBaseMulta;
    }
}
