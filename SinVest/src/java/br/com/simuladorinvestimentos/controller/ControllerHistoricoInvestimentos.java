/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.simuladorinvestimentos.controller;

import br.com.simuladorinvestimentos.model.Cliente;
import br.com.simuladorinvestimentos.model.HistoricoInvestimentos;
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


    public ControllerHistoricoInvestimentos() {
    }

    public List<HistoricoInvestimentos> recuperaHistorico() {
        Cliente clienteLogado = (Cliente) FacesContext.getCurrentInstance().
                getExternalContext().getSessionMap().get("user");
        List<HistoricoInvestimentos> comparacoes = clienteLogado.getHistorico();
        return comparacoes;
    }

}
