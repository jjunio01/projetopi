/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.simuladorinvestimentos.model.dao;

import br.com.simuladorinvestimentos.util.ErroSistema;
import br.com.simuladorinvestimentos.model.InvestCDB;
import br.com.simuladorinvestimentos.model.InvestPoupanca;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Jose Junio
 */
public class InvestimentoDAO implements DAOGenerico{
    
    
    private static InvestimentoDAO instance;

    private InvestimentoDAO() {
    }

    public static InvestimentoDAO getInstance() {

        if (instance == null) {
            instance = new InvestimentoDAO();
        }
        return instance;
    }    
    

    public void salvar(InvestPoupanca objeto) throws ErroSistema{
        Session session = DAOBancoMySql.iniciarTransacao();
        session.saveOrUpdate(objeto);
        DAOBancoMySql.fecharTransacao(session);
    }
    
    public void atualizar(InvestPoupanca objeto) throws ErroSistema{
        Session session = DAOBancoMySql.iniciarTransacao();
        session.update(objeto);
        DAOBancoMySql.fecharTransacao(session);
    }
    
     public void salvar(InvestCDB cdb) throws ErroSistema{
        Session session = DAOBancoMySql.iniciarTransacao();
        session.saveOrUpdate(cdb);
        DAOBancoMySql.fecharTransacao(session);
    }
    
    public void atualizar(InvestCDB cdb) throws ErroSistema{
        Session session = DAOBancoMySql.iniciarTransacao();
        session.update(cdb);
        DAOBancoMySql.fecharTransacao(session);
    }

    @Override
    public void create(Object t) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Object t) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object read(String c) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String txt) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List readALL() throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

       
}
