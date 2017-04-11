package model.entidades;

import model.entidades.InvestCDB;
import model.invest.InvestPoupanca;

public class ComparaInvest {
    
    private InvestPoupanca investPoup;
    private InvestCDB investCdb;

    public ComparaInvest(InvestPoupanca investPoup, InvestCDB investCdb) {
        this.investPoup = investPoup;
        this.investCdb = investCdb;
    }

    public InvestPoupanca getInvestPoup() {
        return investPoup;
    }

    public void setInvestPoup(InvestPoupanca investPoup) {
        this.investPoup = investPoup;
    }

    public InvestCDB getInvestCdb() {
        return investCdb;
    }

    public void setInvestCdb(InvestCDB investCdb) {
        this.investCdb = investCdb;
    }
    
    public static void comparaInvestimento(InvestPoupanca investP, InvestCDB investC){
        
    }
    
    
    
}
