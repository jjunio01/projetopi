/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.simuladorinvestimentos.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Jose Junio
 */
public class DAOBancoMySql {

    private static DAOBancoMySql instance;
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private DAOBancoMySql() {
        this.sessionFactory = abrirSession();
    }

    public static DAOBancoMySql getInstance() {

        if (instance == null) {
            instance = new DAOBancoMySql();
        }
        return instance;
    }

    public SessionFactory abrirSession() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        return factory;
    }

    /*public SessionFactory abrirSession() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        return factory;
    }
      public void create(G g){
        Session session = abrirSession().openSession();
        session.beginTransaction();
        session.save(g);
        session.getTransaction().commit();
        session.close();
    }*/
}
