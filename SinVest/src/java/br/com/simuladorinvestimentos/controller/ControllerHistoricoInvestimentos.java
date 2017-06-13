/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.simuladorinvestimentos.controller;

import br.com.simuladorinvestimentos.model.Cliente;
import br.com.simuladorinvestimentos.model.HistoricoInvestimentos;
import br.com.simuladorinvestimentos.model.InvestPoupanca;
import br.com.simuladorinvestimentos.model.Investimento;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jose Junio
 */
@ManagedBean
@SessionScoped
public class ControllerHistoricoInvestimentos {
    
    private Investimento investimento;
    private HistoricoInvestimentos histInvestimento;


    public ControllerHistoricoInvestimentos() {
    }

    public List<HistoricoInvestimentos> recuperaHistorico() {       
        Cliente clienteLogado = (Cliente) FacesContext.getCurrentInstance().
                getExternalContext().getSessionMap().get("user");
        List<HistoricoInvestimentos> comparacoes = clienteLogado.getHistorico();
        investimento = new InvestPoupanca();
        histInvestimento = comparacoes.get(0);        
        investimento.setValor(histInvestimento.getInvestimentos().get(0).getValor());
        investimento.setPeriodo(histInvestimento.getInvestimentos().get(0).getPeriodo());
        return comparacoes;
    }

    public Investimento getInvestimento() {
        return investimento;
    }

    public void setInvestimento(Investimento investimento) {
        this.investimento = investimento;
    }

    public HistoricoInvestimentos getHistInvestimento() {
        return histInvestimento;
    }

    public void setHistInvestimento(HistoricoInvestimentos histInvestimento) {
        this.histInvestimento = histInvestimento;
    }
    
    

}
