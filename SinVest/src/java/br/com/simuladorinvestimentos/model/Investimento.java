/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.simuladorinvestimentos.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jose Junio
 */
@Entity
public abstract class Investimento implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private double valor;
    private int periodo;
    private double rendimentos;
    private double indiceRendimento;
    private double valorAtualizado;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAcesso;
    private String tipo;

    public Investimento() {

    }
    
    public abstract void calcularRendimentos();

    public Integer getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getPeriodo() {

        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public double getRendimentos() {
        return rendimentos;
    }

    public void setRendimentos(double rendimentos) {
        this.rendimentos = rendimentos;
    }

    public double getIndiceRendimento() {
        return indiceRendimento;
    }

    public void setIndiceRendimento(double indiceRendimento) {
        this.indiceRendimento = indiceRendimento;
    }

    public double getValorAtualizado() {
        return valorAtualizado;
    }

    public void setValorAtualizado(double valorAtualizado) {
        this.valorAtualizado = valorAtualizado;
    }

    public Date getDataAcesso() {
        return dataAcesso;
    }

    public void setDataAcesso(Date dataAcesso) {
        this.dataAcesso = dataAcesso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
