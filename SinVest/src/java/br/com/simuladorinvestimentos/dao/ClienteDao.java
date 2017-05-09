/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.simuladorinvestimentos.dao;

import br.com.simuladorinvestimentos.entity.Cliente;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Jose Junio
 */
public class ClienteDao implements DAOGenerico<Cliente> {

    private static ClienteDao instance;

    private ClienteDao() {
    }

    public static ClienteDao getInstance() {

        if (instance == null) {
            instance = new ClienteDao();
        }
        return instance;
    }

    @Override
    public void create(Cliente t) {
        Session session = DAOBancoMySql.iniciarTransacao();
        session.save(t);
        DAOBancoMySql.fecharTransacao(session);
    }

    @Override
    public void update(Cliente t) {
        Session session = DAOBancoMySql.iniciarTransacao();
        session.update(t);
        DAOBancoMySql.fecharTransacao(session);

    }

    @Override
    public Cliente read(String cpf) {
        Session session = DAOBancoMySql.iniciarTransacao();
        List<Cliente> clientes = readALL();
        Cliente cli = null;

        for (int i = 0; i < clientes.size(); i++) {

            if (cpf.equals(clientes.get(i).getCpf())) {
                cli = clientes.get(i);
            }
        }
        DAOBancoMySql.fecharTransacao(session);
        return cli;
    }

    @Override
    public void delete(String consult) {
        Session session = DAOBancoMySql.iniciarTransacao();
        List<Cliente> clientes = readALL();
        Cliente cli = null;
        for (int i = 0; i < clientes.size(); i++) {

            if (consult.equals(clientes.get(i).getCpf())) {
                cli = clientes.get(i);
            }
        }
        session.delete(cli);
        DAOBancoMySql.fecharTransacao(session);
    }

    @Override
    public List<Cliente> readALL() {
        Session session = DAOBancoMySql.iniciarTransacao();
        Query consulta = session.createQuery("from Cliente");
        List<Cliente> clientes = consulta.list();
        DAOBancoMySql.fecharTransacao(session);
        return clientes;
    }
}
