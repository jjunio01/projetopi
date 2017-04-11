package entidades;

public class InvestPoupanca {
    
    private double saldo;
    private double txJuros;
    private int periodo;

    public InvestPoupanca(double saldo, int periodo) {
        this.saldo = saldo;
        this.periodo = periodo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getTxJuros() {
        return txJuros;
    }

    public void setTxJuros(double txJuros) {
        this.txJuros = txJuros;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }
    
    
    public static double calcularJuros(double saldo, int peridodo ){
        double valorAtualizado = 0;
        return valorAtualizado;
    }
    
}
