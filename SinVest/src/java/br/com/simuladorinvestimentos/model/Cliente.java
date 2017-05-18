package br.com.simuladorinvestimentos.model;

import com.sun.istack.internal.Nullable;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    @Nullable
    private Usuario usu;

    public Cliente(String nome, String cpf, Date dataNasc, String email, Usuario usu) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.email = email;
        this.usu = usu;
    }

    public Cliente() {
            usu = new Usuario();
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

}
