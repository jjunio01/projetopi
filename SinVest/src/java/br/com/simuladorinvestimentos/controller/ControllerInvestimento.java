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
import java.util.Date;
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
    private List<Investimento> listaInvestimentos;
   

    public ControllerInvestimento() {
        listaInvestimentos = new ArrayList<>();
    }

    //Salva os investimentos no banco de dados
     public void salvar(Investimento investimento) throws ErroSistema {

        if (investimento instanceof InvestPoupanca) {
            investDao.salvar(poupanca);
            calcularRendimentos(poupanca);

        } else if (investimento instanceof InvestCDB) {
            investDao.salvar(this.cdb);
            calcularRendimentos(this.cdb);

        } else if (investimento instanceof InvestLCI) {
            investDao.salvarLCI(lci);
            calcularRendimentos(this.lci);

        }
    }
    //Calcula rendimentos da poupança
    public void calcularRendimentos(int periodo) {

        poupanca.setPeriodo(periodo * 30);
        poupanca.calcularRendimentos();

    }
    //Calcula os rendimentos.
    public void calcularRendimentos(Investimento investimento) throws ErroSistema {

        if (investimento instanceof InvestPoupanca) {
            poupanca.calcularRendimentos();

        } else if (investimento instanceof InvestCDB) {
            cdb.calcularRendimentos();

        } else if (investimento instanceof InvestLCI) {
            lci.calcularRendimentos();

        }
    }

    public void compararInvestimentos(int periodo, double valor) throws ErroSistema {
        //Setta o valor e o período.
        poupanca.setValor(valor);
        poupanca.setPeriodo(periodo * tipoPrazo);
        cdb.setValor(valor);
        cdb.setPeriodo(periodo * tipoPrazo);
        lci.setValor(valor);
        lci.setPeriodo(periodo * tipoPrazo);
        //Setta a data da simulação.
        poupanca.setDataAcesso(new Date());
        cdb.setDataAcesso(new Date());
        lci.setDataAcesso(new Date());
        poupanca.setTipo("Poupança");
        cdb.setTipo("CDB");
        lci.setTipo("LCI");
        //Salva as simulações no banco de dados.
        salvar(poupanca);
        salvar(cdb);
        salvar(lci);
        listaInvestimentos.add(poupanca);
        listaInvestimentos.add(cdb);
        listaInvestimentos.add(lci);
    }
    
    public InvestPoupanca getPoupanca() {
        return (InvestPoupanca) poupanca;
    }

    public void setPoupanca(InvestPoupanca poupanca) {
        this.poupanca = poupanca;
    }

    public InvestCDB getCdb() {
        return (InvestCDB) cdb;
    }

    public void setCdb(InvestCDB cdb) {
        this.cdb = cdb;
    }

    public InvestLCI getLci() {
        return (InvestLCI) lci;
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

    public List<Investimento> getListaInvestimentos() {
        return listaInvestimentos;
    }

    public void setListaInvestimentos(List<Investimento> listaInvestimentos) {
        this.listaInvestimentos = listaInvestimentos;
    }

    public String formataValor(double investimento) {

        return String.format("%.2f", investimento);
    }
  
}
