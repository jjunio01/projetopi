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
public class InvestPoupanca implements Investimentos{
    
    private Poupanca poup;
    private double txJuros;
    private double txSelic = 11.25;
    private double txTr = 0.0929;
    
    
    public void salvarPoup(Poupanca p) throws ErroSistema{
        InvestDao.getInstance().salvarPoupanca(p);
    }

    @Override
    public void calcularRendimentos(Poupanca p) {
        
        if (txSelic > 8.5){
            this.txJuros = 0.005 + txTr; 
        } else {
            this.txJuros = ((0.7 * txSelic) / 12 ) + txTr; 
        }
        int periodo = p.getPeriodo() / 30;
        
            p.setRendimentos(p.getValor() * this.txJuros * periodo);
        
        InvestPoupanca invest = new InvestPoupanca();
        invest.setPoup(p);
        try {
            InvestDao.getInstance().salvarPoupanca(p);
        } catch (ErroSistema ex) {
            Logger.getLogger(InvestPoupanca.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public Poupanca getPoup() {
        return poup;
    }

    public void setPoup(Poupanca poup) {
        this.poup = poup;
    }

    public double getTxJuros() {
        return txJuros;
    }

    public void setTxJuros(double txJuros) {
        this.txJuros = txJuros;
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
    
    
    
}
