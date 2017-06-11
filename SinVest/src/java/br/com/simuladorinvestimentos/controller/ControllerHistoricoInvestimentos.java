/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.simuladorinvestimentos.controller;

import br.com.simuladorinvestimentos.model.HistoricoInvestimentos;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Jose Junio
 */
@ManagedBean
@SessionScoped
public class ControllerHistoricoInvestimentos {

    private HistoricoInvestimentos historico;
    

    public ControllerHistoricoInvestimentos() {
    }

    public HistoricoInvestimentos getHistorico() {
        return historico;
    }

    public void setHistorico(HistoricoInvestimentos historico) {
        this.historico = historico;
    }

}
