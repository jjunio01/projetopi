package br.com.simuladorinvestimentos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(length = 40, nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String cpf;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataNasc;
    @Column(nullable = false)
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Investimento> listaInvestimentos;

    public Cliente(String nome, String cpf, Date dataNasc, String email, Usuario usuario) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.email = email;
        this.usuario = usuario;
    }

    public Cliente() {
        usuario = new Usuario();
        List<Investimento> lista = new ArrayList<>();
        this.setListaInvestimentos(lista);
    }

    public Integer getId() {
        return this.id;
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

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Investimento> getListaInvestimentos() {
        return listaInvestimentos;
    }

    public void setListaInvestimentos(List<Investimento> listaInvestimentos) {
        this.listaInvestimentos = listaInvestimentos;
    }

}
