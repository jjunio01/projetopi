/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.simuladorinvestimentos.controller;

import br.com.simuladorinvestimentos.model.ErroSistema;
import br.com.simuladorinvestimentos.model.Investimentos;
import br.com.simuladorinvestimentos.model.Poupanca;
import br.com.simuladorinvestimentos.model.dao.InvestDao;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Jose Junio
 */
@ManagedBean
@RequestScoped
public class ControllerPoupanca implements Investimentos {

    private Poupanca poup = new Poupanca();
    private double txSelic = 11.25;
    private double txTr = 0.0001036;
    private double indiceCorrecao;
    private double txAdicional;

    public void salvarPoup() throws ErroSistema {
        InvestDao.getInstance().salvarPoupanca(this.poup);
        calcularRendimentos();
    }

    @Override
    public void calcularRendimentos() {

        int periodo = this.poup.getPeriodo() / 30;

        if (periodo == 0) {
            this.poup.setRendimentos(0);
        } else {
            this.poup.setRendimentos(this.poup.getValor() * this.getIndiceCorrecao() * periodo);
        }
        try {
            InvestDao.getInstance().atualizarPoupanca(this.poup);
        } catch (ErroSistema ex) {
            Logger.getLogger(ControllerPoupanca.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Poupanca getPoup() {
        return poup;
    }

    public void setPoup(Poupanca poup) {
        this.poup = poup;
    }

    public double getTxSelic() {
        return txSelic;
    }

    public void setTxSelic(double txSelic) {
        this.txSelic = txSelic;
    }

    public double getTxTr() {
        return txTr;
    }

    public void setTxTr(double txTr) {
        this.txTr = txTr;
    }

    public double getIndiceCorrecao() {

        if (this.txSelic > 8.5) {
            indiceCorrecao = 0.005 + this.txTr;
        } else {
            this.indiceCorrecao = 1;
        }
        return indiceCorrecao;
    }

    public double getTxAdicional() {
        return txAdicional;
    }

    public void setTxAdicional(double txAdicional) {
        this.txAdicional = txAdicional;
    }

    public ControllerPoupanca() {
    }
    
    
}
