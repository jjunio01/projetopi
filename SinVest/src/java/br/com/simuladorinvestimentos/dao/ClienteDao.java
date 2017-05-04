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
    
     /*public SessionFactory abrirSession() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        return factory;
    }*/

    @Override
    public void create(Cliente t) {
        Session session = DAOBancoMySql.getInstance().abrirSession().openSession();
        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Cliente t) {
       Session session = DAOBancoMySql.getInstance().abrirSession().openSession();
        session.beginTransaction();
        session.update(t);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Cliente read(String consul) {
        Session session = DAOBancoMySql.getInstance().abrirSession().openSession();
        List<Cliente> clientes = readALL();
        Cliente cli = null;

        for (int i = 0; i < clientes.size(); i++) {

            if (consul.equals(clientes.get(i).getCpf())) {
                cli = clientes.get(i);
            }
        }
        session.close();
        return cli;

    }

    @Override
    public void delete(String consult) {
        Session session = DAOBancoMySql.getInstance().abrirSession().openSession();
        session.beginTransaction();
        List<Cliente> clientes = readALL();
        Cliente cli = null;

        for (int i = 0; i < clientes.size(); i++) {

            if (consult.equals(clientes.get(i).getCpf())) {
                cli = clientes.get(i);
            }
        }
        session.delete(cli);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Cliente> readALL() {
        Session session = DAOBancoMySql.getInstance().abrirSession().openSession();
        Query consulta = session.createQuery("from Cliente");
        List<Cliente> clientes = consulta.list();
        session.close();
        return clientes;
    }

}
