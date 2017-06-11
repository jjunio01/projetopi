/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.simuladorinvestimentos.model.dao;

import br.com.simuladorinvestimentos.util.ErroSistema;
import br.com.simuladorinvestimentos.model.InvestCDB;
import br.com.simuladorinvestimentos.model.InvestLCI;
import br.com.simuladorinvestimentos.model.InvestPoupanca;
import org.hibernate.Session;

/**
 *
 * @author Jose Junio
 */
public class InvestimentoDAO {
    
    
    private static InvestimentoDAO instance;

    private InvestimentoDAO() {
    }
    //Método que cria uma instância única de InvetimentoDAO
    public static InvestimentoDAO getInstance() {

        if (instance == null) {
            instance = new InvestimentoDAO();
        }
        return instance;
    }    
    
    //Método para salvar uma Poupanca
    public void salvar(InvestPoupanca poupanca) throws ErroSistema{
        //Abre uma conexão com o banco e inicia uma trasação
        Session session = DAOBancoMySql.iniciarTransacao();
        //Salva o objeto no banco de dados.
        session.saveOrUpdate(poupanca);
        //Recupera a sessão aberta encerra a transação e fecha a conexão;
        DAOBancoMySql.fecharTransacao(session);
    }
    //Método para salvar uma CDB
    public void salvar(InvestCDB cdb) throws ErroSistema{
        Session session = DAOBancoMySql.iniciarTransacao();
        session.saveOrUpdate(cdb);
        DAOBancoMySql.fecharTransacao(session);
    }
    //Método para salvar uma LCI
    public void salvarLCI(InvestLCI lci) throws ErroSistema{
        Session session = DAOBancoMySql.iniciarTransacao();
        session.saveOrUpdate(lci);
        DAOBancoMySql.fecharTransacao(session);
    }
    
}
