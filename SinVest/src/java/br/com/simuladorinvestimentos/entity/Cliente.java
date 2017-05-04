package br.com.simuladorinvestimentos.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Cliente {

    @Id
    @GeneratedValue
    private int id;
    @Column(length = 30)
    private String nome;
    @Column(length = 30)
    private String cpf;

    /*@Temporal(TemporalType.DATE)
    private Date dataNasc;
    @Column(length = 40)
    private String email;*/

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
