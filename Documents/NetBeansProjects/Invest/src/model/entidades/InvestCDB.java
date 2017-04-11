package model.entidades;

public class InvestCDB extends Investimentos{
        
        private double txJuros;
    
    public InvestCDB(double saldo, int periodo) {
        super(saldo, periodo);
    }

    public double getTxJuros() {
        return txJuros;
    }

    public void setTxJuros(double txJuros) {
        this.txJuros = txJuros;
    }
    
        @Override
    public void calcularJuros(){
        
    }
    
}
