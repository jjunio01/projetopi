/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.simuladorinvestimentos.controller;

import br.com.simuladorinvestimentos.util.ErroSistema;
import br.com.simuladorinvestimentos.model.InvestCDB;
import br.com.simuladorinvestimentos.model.InvestPoupanca;
import br.com.simuladorinvestimentos.model.dao.InvestimentoDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Jose Junio
 */
@ManagedBean
@SessionScoped
public class ControllerInvestimentos {

    private InvestPoupanca poupanca = new InvestPoupanca();
    private InvestCDB cdb = new InvestCDB();
    private InvestimentoDAO investDao = InvestimentoDAO.getInstance();

    public void salvarInvestimento(InvestPoupanca poupanca) throws ErroSistema {
        investDao = InvestimentoDAO.getInstance();
        investDao.salvar(poupanca);
        calcularRendimentos(poupanca);
    }

    public void calcularRendimentos(InvestPoupanca poupanca) throws ErroSistema {
        poupanca.calcularRendimentos();
        investDao.atualizar(poupanca);

    }

    public void salvarInvestimentos() throws ErroSistema {
        investDao = InvestimentoDAO.getInstance();
        investDao.salvar(this.cdb);
        calcularRendimento(this.cdb);

    }

    public void calcularRendimento(InvestCDB cdb) throws ErroSistema {
        cdb.calcularRendimentos();
        investDao.atualizar(cdb);
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

    public ControllerInvestimentos() {
    }

}
