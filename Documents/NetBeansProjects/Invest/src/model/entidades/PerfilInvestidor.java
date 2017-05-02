package model.entidades;

import model.entidades.Cliente;
import model.entidades.Questionario;

public class PerfilInvestidor {
    
    private Cliente cliente;
    private Questionario questionario;
    private String tipo;

    public PerfilInvestidor(Cliente cliente, Questionario questionario, String tipo) {
        this.cliente = cliente;
        this.questionario = questionario;
        this.tipo = tipo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Questionario getQuestionario() {
        return questionario;
    }

    public void setQuestionario(Questionario questionario) {
        this.questionario = questionario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void analisedoPerfil(){
        
    }
    
    
    
}
