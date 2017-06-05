/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.simuladorinvestimentos.controller;

import br.com.simuladorinvestimentos.util.ErroSistema;
import br.com.simuladorinvestimentos.model.InvestCDB;
import br.com.simuladorinvestimentos.model.InvestLCI;
import br.com.simuladorinvestimentos.model.InvestPoupanca;
import br.com.simuladorinvestimentos.model.Investimento;
import br.com.simuladorinvestimentos.model.dao.InvestimentoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Jose Junio
 */
@ManagedBean
@RequestScoped
public class ControllerInvestimento {

    private InvestPoupanca poupanca = new InvestPoupanca();
    private InvestCDB cdb = new InvestCDB();
    private InvestLCI lci = new InvestLCI();
    private InvestimentoDAO investDao = InvestimentoDAO.getInstance();
    private int tipoPrazo;
    private List<Investimento> investimentos;

    public void salvarInvestimento() throws ErroSistema {
        investDao.salvar(poupanca);
        calcularRendimentos(poupanca);
    }

    public void calcularRendimentos(InvestPoupanca poupanca) throws ErroSistema {
        poupanca.calcularRendimentos();
        investDao.atualizar(poupanca);

    }

    public void salvarInvestimentos() throws ErroSistema {
        investDao.salvar(this.cdb);
        calcularRendimento(this.cdb);

    }

    public void calcularRendimento(InvestCDB cdb) throws ErroSistema {
        cdb.calcularRendimentos();
        investDao.atualizar(cdb);
    }

    public void salvarLCI() throws ErroSistema {
        investDao.salvarLCI(lci);
        calcularRendimentoLCI(this.lci);

    }

    public void calcularRendimentoLCI(InvestLCI lci) throws ErroSistema {
        lci.calcularRendimentos();
        investDao.atualizar(lci);
    }

    public void compararInvestimentos(int periodo, double valor) throws ErroSistema {
        poupanca.setValor(valor);
        poupanca.setPeriodo(periodo * tipoPrazo);
        cdb.setValor(valor);
        cdb.setPeriodo(periodo * tipoPrazo);
        lci.setValor(valor);
        lci.setPeriodo(periodo * tipoPrazo);
        salvarInvestimento();
        salvarInvestimentos();
        salvarLCI();
        this.investimentos = new ArrayList<>();
        investimentos.add(poupanca);
        investimentos.add(cdb);
        investimentos.add(lci);
    }

    public InvestPoupanca getPoupanca() {
        return poupanca;
    }

    public void setPoupanca(InvestPoupanca poupanca) {
        this.poupanca = poupanca;
    }

    public InvestCDB getCdb() {
        return cdb;
    }

    public void setCdb(InvestCDB cdb) {
        this.cdb = cdb;
    }

    public ControllerInvestimento() {
    }

    public InvestLCI getLci() {
        return lci;
    }

    public void setLci(InvestLCI lci) {
        this.lci = lci;
    }

    public int getTipoPrazo() {
        return tipoPrazo;
    }

    public void setTipoPrazo(int tipoPrazo) {
        this.tipoPrazo = tipoPrazo;
    } 

    public List<Investimento> getInvestimentos() {
        return investimentos;
    }

    public void setInvestimentos(List<Investimento> investimentos) {
        this.investimentos = investimentos;
    }
    
    

}
