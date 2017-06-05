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
public class InvestPoupanca extends Investimento {

    private double taxaTr = 0.0001069;
    private double taxaSelic = 11.25;
    private double taxaAdicional;

    public InvestPoupanca() {
    }

    @Override
    public void calcularRendimentos() {
        
        this.setRendimentos((this.getValor() * Math.pow( 1 + getIndiceRendimento(),this.getPeriodo())) - this.getValor());
                
    }

    public double getTaxaTr() {
        return taxaTr;
    }

    public void setTaxaTr(double taxaTr) {
        this.taxaTr = taxaTr;
    }

    public double getTaxaSelic() {
        return taxaSelic;
    }

    public void setTaxaSelic(double taxaSelic) {
        this.taxaSelic = taxaSelic;
    }

    public double getTaxaAdicional() {
        if (this.taxaSelic > 8.5) {
            this.taxaAdicional = 0.0053;
        }
        return taxaAdicional;
    }

    public void setTaxaAdicional(double taxaAdicional) {
        this.taxaAdicional = taxaAdicional;
    }

    @Override
    public double getIndiceRendimento() {
        setIndiceRendimento( getTaxaAdicional() + this.taxaTr);
        return super.getIndiceRendimento();
    }

    @Override
    public double getValorAtualizado() {        
        setValorAtualizado(this.getValor() + this.getRendimentos());
        return super.getValorAtualizado();
    }

    

}
