package model.entidades;

public class Investimentos {
    
    protected double saldo;
    protected int periodo;

    public Investimentos(double saldo, int periodo) {
        this.saldo = saldo;
        this.periodo = periodo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public void calcularJuros() {
        
    }
    
}
