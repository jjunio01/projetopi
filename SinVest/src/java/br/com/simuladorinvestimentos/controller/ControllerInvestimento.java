/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.simuladorinvestimentos.controller;

import br.com.simuladorinvestimentos.model.Cliente;
import br.com.simuladorinvestimentos.model.HistoricoInvestimentos;
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
import javax.faces.context.FacesContext;

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
    private List<HistoricoInvestimentos> historicoInvestimento;

    public ControllerInvestimento() {
    }

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

    public void calcularRendimentos(int periodo) {

        poupanca.setPeriodo(periodo * 30);
        poupanca.calcularRendimentos();

    }

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
        poupanca.setValor(valor);
        poupanca.setPeriodo(periodo * tipoPrazo);
        cdb.setValor(valor);
        cdb.setPeriodo(periodo * tipoPrazo);
        lci.setValor(valor);
        lci.setPeriodo(periodo * tipoPrazo);
        salvar(poupanca);
        salvar(cdb);
        salvar(lci);
        this.investimentos = new ArrayList<>();
        investimentos.add(poupanca);
        investimentos.add(cdb);
        investimentos.add(lci);
        Cliente clienteLogado = (Cliente) FacesContext.getCurrentInstance().
                getExternalContext().getSessionMap().get("user");
        historicoInvestimento = new ArrayList<>();
        HistoricoInvestimentos histInvestimento= new HistoricoInvestimentos();
        histInvestimento.setDataAcesso(new Date());
        histInvestimento.setInvestimentos(investimentos);
        historicoInvestimento.add(histInvestimento);
        clienteLogado.setHistorico(historicoInvestimento);
        ControllerCliente contCliente = new ControllerCliente();
        contCliente.setCliente(clienteLogado);
        contCliente.alterar();
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

    public String formataValor(double investimento) {

        return String.format("%.2f", investimento);
    }

    public List<HistoricoInvestimentos> getHitorico() {
        return historicoInvestimento;
    }

    public void setHitorico(List<HistoricoInvestimentos> hitorico) {
        this.historicoInvestimento = hitorico;
    }

}
