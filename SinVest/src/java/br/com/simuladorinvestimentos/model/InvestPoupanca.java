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
        //Calcula os juros mensais do valor, utilizando juros compostos.
        if (super.getPeriodo() >= 30) {
            this.setRendimentos((this.getValor() * Math.pow(
                    1 + getIndiceRendimento(), periodo())) - this.getValor());
        }
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
        setTaxaAdicional();
        return taxaAdicional;
    }

    public void setTaxaAdicional() {
        //Atualiza a taxa de rendimento adicinao de acordo com a Taxa Selic Vigente
        if (this.taxaSelic > 8.5) {
            this.taxaAdicional = 0.0053;
        } else {
            this.taxaAdicional = getTaxaSelic() * 0.7;
        }
    }

    public int periodo() {
        setPeriodo();
        return super.getPeriodo();
    }

    public void setPeriodo() {

        if (super.getPeriodo() < 30) {
            this.setRendimentos(0);
        } else if (super.getPeriodo() == 30) {
            super.setPeriodo(1);
        } else {
            super.setPeriodo(super.getPeriodo() / 30);
        }
    }

    @Override
    public double getIndiceRendimento() {
        setIndiceRendimento(getTaxaAdicional() + this.taxaTr);
        return super.getIndiceRendimento();
    }

    @Override
    public double getValorAtualizado() {
        setValorAtualizado(this.getValor() + this.getRendimentos());
        return super.getValorAtualizado();
    }

}
