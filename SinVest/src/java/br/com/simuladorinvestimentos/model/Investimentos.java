/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.simuladorinvestimentos.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Jose Junio
 */
@Entity
public abstract class Investimentos implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private double valor;
    private int periodo;
    private double rendimentos;

    public Investimentos() {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public abstract void calcularRendimentos();

}
