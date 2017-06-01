/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.simuladorinvestimentos.model;

/**
 *
 * @author Jose Junio
 */
public class InvestLCI extends Investimento {

    private final double cdi = 11.13;
    private double indiceRendimentos;
    private double percentCDI = 90;

    public InvestLCI() {
    }

    @Override
    public void calcularRendimentos() { 
        indiceRendimentos = (this.getPercentCDI() * cdi) / 100;
        
        this.setRendimentos(this.getRendimentos() * (indiceRendimentos + 1) * this.getPeriodo());

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

}
