package model.entidades;

import java.util.Date;

public class Cliente {

    private String nome;
    private String cpf;
    private String endereco;
    private int idade;
    private Date dataNasc;
    private String naturalidade;
    private String nomePai;
    private String nomeMae;

    public Cliente(String nome, String cpf, String end, int idade, Date dataNasc, String naturalidade, String nomePai, String nomeMae) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = end ;
        this.idade = idade;
        this.dataNasc = dataNasc;
        this.naturalidade = naturalidade;
        this.nomePai = nomePai;
        this.nomeMae = nomeMae;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

}
