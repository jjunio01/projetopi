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
public class InvestCDB extends Investimento {

    private double taxaIR;
    private final double cdi = 11.13;
    private double indiceRendimentos;
    private double percentCDI = 90;
    private double rendimentoLiquido;

    public InvestCDB() {
    }

    @Override
    public void calcularRendimentos() {

        for (int i = 0; i < this.getPeriodo(); i++) {
            indiceRendimentos = 1;
            
            indiceRendimentos = indiceRendimentos * Math.pow((Math.pow(((getCdi() / 100) + 1), 0.003968254)), this.getPeriodo());

        }

        this.setRendimentos(((indiceRendimentos - 1) * this.getValor()));
        
        this.setRendimentoLiquido(this.getRendimentos() *(1-this.getTaxaIR()));
    }

    public double getTaxaIR() {
        if (getPeriodo() <= 180) {
            setTaxaIR(0.2250);
        } else if (getPeriodo() > 180 && getPeriodo() <= 360) {
            setTaxaIR(0.2000);
        } else if (getPeriodo() > 360 && getPeriodo() <= 720) {
            setTaxaIR(0.1750);
        } else if (getPeriodo() > 720) {
            setTaxaIR(0.1500);
        }
        return taxaIR;
    }

    public void setTaxaIR(double taxaIR) {
        this.taxaIR = taxaIR;
    }

    public double getCdi() {
        return cdi * (getPercentCDI() / 100);
    }

    public double getIndiceRendimentos() {
        return indiceRendimentos;
    }

    public void setIndiceRendimentos(double indiceRendimentos) {
        this.indiceRendimentos = indiceRendimentos;
    }

    public double getPercentCDI() {
        return percentCDI;
    }

    public void setPercentCDI(double percentCDI) {
        this.percentCDI = percentCDI;
    }

    public double getRendimentoLiquido() {
        return rendimentoLiquido;
    }

    public void setRendimentoLiquido(double rendimentoLiquido) {
        this.rendimentoLiquido = rendimentoLiquido;
    }

}
