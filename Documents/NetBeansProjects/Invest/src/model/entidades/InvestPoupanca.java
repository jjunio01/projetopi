package model.invest;

import model.entidades.Investimentos;

public class InvestPoupanca extends Investimentos{
    
    private double txJuros;

    public InvestPoupanca(double saldo, int periodo) {
        super(saldo, periodo);
    }
    
    @Override
    public void calcularJuros(){
        
    }

    public double getTxJuros() {
        return txJuros;
    }

    public void setTxJuros(double txJuros) {
        this.txJuros = txJuros;
    }
    
    
    
    
}
