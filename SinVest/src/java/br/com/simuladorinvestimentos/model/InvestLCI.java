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

    private final double cdi = 10.14;
    private double percentCDI = 80;

    public InvestLCI() {
    }

    @Override
    public void calcularRendimentos() {
        //Verifica se o périodo é inferior a 90 dias.
        if (getPeriodo() < 90) {
            Message.getInstance().adicionarMensagem(
                    null, "Período para o LCI deve ser igual ou superior a 90 dias", FacesMessage.SEVERITY_WARN);
            this.setValorAtualizado(getValor() + getRendimentos());
            return;
        }

        for (int i = 0; i < this.getPeriodo(); i++) {
            setIndiceRendimento(1);
            //Calcula o índice de rendimento capitalizados ao dia
            setIndiceRendimento(getIndiceRendimento() * Math.pow((Math.pow(((getCdi() / 100) + 1), 0.003968254)), this.getPeriodo()));
        }
        //Atualiza o valor dos rendimentos;
        this.setRendimentos(((getIndiceRendimento() - 1) * this.getValor()));
        this.setValorAtualizado(getValor() + getRendimentos());

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

}
