/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.simuladorinvestimentos.model;

import br.com.simuladorinvestimentos.util.Message;
import javax.faces.application.FacesMessage;
import javax.persistence.Entity;

/**
 *
 * @author Jose Junio
 */
@Entity
public class InvestLCI extends Investimento {

    private final double cdi = 11.13;
    private double percentCDI = 90;

    public InvestLCI() {
    }

    @Override
    public void calcularRendimentos() {
        if (getPeriodo() < 90) {
            Message.getInstance().adicionarMensagem(
                    null, "O prazo para o LCI deve ser igual ou superior a 90 dias", FacesMessage.SEVERITY_WARN);
            return;
        }

        for (int i = 0; i < this.getPeriodo(); i++) {
            setIndiceRendimento(1);

            setIndiceRendimento(getIndiceRendimento() * Math.pow((Math.pow(((getCdi() / 100) + 1), 0.003968254)), this.getPeriodo())); 
        }

        this.setRendimentos(((getIndiceRendimento() - 1) * this.getValor()));
        valorAtualizado = getValor() + getRendimentos();

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

    @Override
    public double getValorAtualizado() {
        return super.getValorAtualizado();
    }

    @Override
    public void setValorAtualizado(double valorAtualizado) {
        this.valorAtualizado = valorAtualizado;
    }

}
