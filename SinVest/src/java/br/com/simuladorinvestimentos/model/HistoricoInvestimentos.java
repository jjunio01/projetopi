/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.simuladorinvestimentos.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Jose Junio
 */
@Entity
public class HistoricoInvestimentos implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @OneToMany
    private List<Investimento> investimentos;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataAcesso;

    public HistoricoInvestimentos() {
    }

    public HistoricoInvestimentos(int id, List<Investimento> investimentos, Date dataAcesso) {
        this.id = id;
        this.investimentos = investimentos;
        this.dataAcesso = dataAcesso;
    }

    public int getId() {
        return id;
    }

    public List<Investimento> getInvestimentos() {
        return investimentos;
    }

    public void setInvestimentos(List<Investimento> investimentos) {
        this.investimentos = investimentos;
    }

    public Date getDataAcesso() {
        return dataAcesso;
    }

    public void setDataAcesso(Date dataAcesso) {
        this.dataAcesso = dataAcesso;
    }

}
