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
    private double percentCDI = 90;
    private double rendimentoLiquido;
    private double iof;

    public InvestCDB() {
    }

    @Override
    public void calcularRendimentos() {

        for (int i = 0; i < this.getPeriodo(); i++) {
            setIndiceRendimento(1);
            //Calcula o índice de rendimento capitalizados ao dia.
            setIndiceRendimento(getIndiceRendimento() * Math.pow((Math.pow(((getCdi() / 100) + 1), 0.003968254)), this.getPeriodo()));

        }
        //Atualiza o valor dos rendimentos.
        this.setRendimentos(((getIndiceRendimento() - 1) * this.getValor()));
        //Atualiza o valor do rendimento líquido.
        rendimentoLiquido = getRendimentos() * (1 - getTaxaIR());
        //Atualiza valor atualizado(Valor + Jutos).
        setValorAtualizado(getValor() + rendimentoLiquido - getIof());
    }

    public double getTaxaIR() {
        return taxaIR;
    }

    public void setTaxaIR() {
        if (getPeriodo() <= 126) {
            this.taxaIR = (0.2250);
        } else if (getPeriodo() > 126 && getPeriodo() <= 252) {
            this.taxaIR = (0.2000);
        } else if (getPeriodo() > 252 && getPeriodo() <= 504) {
            this.taxaIR = (0.1750);
        } else if (getPeriodo() > 504) {
            this.taxaIR = (0.1500);
        }

    }

    public double getCdi() {
        return cdi * (getPercentCDI() / 100);
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

    public double getIof() {
        setIof();
        return iof;
    }

    public void setIof() {

        if (getPeriodo() <= 30) {
            this.iof = 0;
        } else {
            this.iof = 0;
        }
    }

    @Override
    public double getValorAtualizado() {
        setValorAtualizado(this.getValor() + this.getRendimentoLiquido());
        return super.getValorAtualizado();
    }

    @Override
    public void setValorAtualizado(double valorAtualizado) {
        super.setValorAtualizado(valorAtualizado);
    }

}
