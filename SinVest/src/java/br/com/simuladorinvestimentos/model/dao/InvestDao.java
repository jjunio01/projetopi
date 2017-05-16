/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.simuladorinvestimentos.model.dao;

import br.com.simuladorinvestimentos.model.ErroSistema;
import br.com.simuladorinvestimentos.model.Poupanca;
import org.hibernate.Session;

/**
 *
 * @author Jose Junio
 */
public class InvestDao {
    
    
     private static InvestDao instance;

    private InvestDao() {
    }

    public static InvestDao getInstance() {

        if (instance == null) {
            instance = new InvestDao();
        }
        return instance;
    }    
    

    public void salvarPoupanca(Poupanca p) throws ErroSistema{
        Session session = DAOBancoMySql.iniciarTransacao();
        session.saveOrUpdate(p);
        DAOBancoMySql.fecharTransacao(session);
    }

    public double recuperarValor() {
        return 0;
    }

}
