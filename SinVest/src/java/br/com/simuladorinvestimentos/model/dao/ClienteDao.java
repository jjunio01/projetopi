/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.simuladorinvestimentos.model.dao;

import br.com.simuladorinvestimentos.model.Cliente;
import br.com.simuladorinvestimentos.model.ErroSistema;
import br.com.simuladorinvestimentos.model.Usuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Jose Junio
 */
public class ClienteDao implements DAOGenerico<Cliente> {

    private static ClienteDao instance;
    Cliente cliente = new Cliente();
    List<Cliente> clientes;

    private ClienteDao() {
    }

    public static ClienteDao getInstance() {

        if (instance == null) {
            instance = new ClienteDao();
        }
        return instance;
    }

    @Override
    public void create(Cliente t) throws ErroSistema {

        Session session = DAOBancoMySql.iniciarTransacao();
        try {
            session.save(t);
        } catch (NullPointerException erroCreate) {
            throw new ErroSistema("Erro ao inserir cliente no banco de dados", erroCreate);
        }
        DAOBancoMySql.fecharTransacao(session);
    }

    @Override
    public void update(Cliente t) throws ErroSistema {
        Session session = DAOBancoMySql.iniciarTransacao();
        try {
            session.update(t);
        } catch (Exception erroUpdate) {
            throw new ErroSistema("Erro ao atualizar cliente no banco de dados", erroUpdate);
        }
        DAOBancoMySql.fecharTransacao(session);
    }

    @Override
    public Cliente read(String cpf) throws ErroSistema {
        Session session = DAOBancoMySql.iniciarTransacao();
        Cliente cli = null;
        try {
            Query consulta = session.createQuery("from Cliente where cpf like '" + cpf + "'");
            cli = (Cliente) consulta.list().get(0);
        } catch (Exception erroRead) {
            throw new ErroSistema("Erro ao consultar cliente", erroRead);
        } finally {
            return cli;
        }

    }

    public Usuario readLogin(String login) throws ErroSistema {
        Session session = DAOBancoMySql.iniciarTransacao();
        Usuario usuario = null;
        try {
            Query consulta = session.createQuery("from Usuario where login like '" + login + "'");
            usuario = (Usuario) consulta.list().get(0);
        } catch (Exception erroReadLogin) {
            throw new ErroSistema("Erro ao consultar login", erroReadLogin);
        } finally{
            return usuario;
        }       

    }

    @Override
    public void delete(String cpf) throws ErroSistema {

        Session session = DAOBancoMySql.iniciarTransacao();
        Cliente cli = null;
        try {
            Query consulta = session.createQuery("from Cliente where cpf like '" + cpf + "'");
            cli = (Cliente) consulta.list().get(0);
            session.delete(cli);
        } catch (Exception erroRead) {
            throw new ErroSistema("Erro ao deletar cliente", erroRead);
        } finally {
            DAOBancoMySql.fecharTransacao(session);
        }

    }

    @Override
    public List<Cliente> readALL() throws ErroSistema {
        Session session = DAOBancoMySql.iniciarTransacao();
        List<Cliente> clientes = null;
        try {
            Session session2 = DAOBancoMySql.iniciarTransacao();
            session = session2;
            Query consulta = session.createQuery("from Cliente");
            clientes = consulta.list();
        } catch (Exception erroReadAll) {
            throw new ErroSistema("Erro ao consultar lista de clientes", erroReadAll);
        }

        DAOBancoMySql.fecharTransacao(session);
        return clientes;
    }
}
