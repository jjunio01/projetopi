package investimentos.model.entidades;

public class InvestPoupanca {

    private double txJuros;
    private Cliente cliente;

    public InvestPoupanca(double saldo, int periodo, Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTxJuros() {
        return txJuros;
    }

    public void setTxJuros(double txJuros) {
        this.txJuros = txJuros;
    }

    

}
