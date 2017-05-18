/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.simuladorinvestimentos.model;

import javax.persistence.Entity;

/**
 *
 * @author Jose Junio
 */
@Entity
public class InvestCDB extends Investimentos {

    private double taxaIR;
    private final double cdi = 0.0375;
    private double indiceRendimentos;

    public InvestCDB() {
    }

    @Override
    public void calcularRendimentos() {
        indiceRendimentos = 1;
        double rend = 0;

        for (int i = 1; i < this.getPeriodo(); i++) {

            indiceRendimentos = indiceRendimentos * Math.pow((Math.pow(((this.cdi / 100) + 1), 0.003968254)), this.getPeriodo());

        }
        rend = ((indiceRendimentos - 1) * this.getValor());

        this.setRendimentos(rend);

    }

    public double getTaxaIR() {
        return taxaIR;
    }

    public void setTaxaIR(double taxaIR) {
        this.taxaIR = taxaIR;
    }

    public double getCdi() {
        return cdi;
    }

    public double getIndiceRendimentos() {
        return indiceRendimentos;
    }

    public void setIndiceRendimentos(double indiceRendimentos) {
        this.indiceRendimentos = indiceRendimentos;
    }

}
