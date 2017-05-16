/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.simuladorinvestimentos.model.dao;

import br.com.simuladorinvestimentos.model.ErroSistema;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.JDBCConnectionException;

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

    private DAOBancoMySql() throws ErroSistema {
        this.sessionFactory = abrirSession();
    }

    public static DAOBancoMySql getInstance() throws ErroSistema {

        if (instance == null) {
            instance = new DAOBancoMySql();
        }
        return instance;
    }

    public SessionFactory abrirSession() throws ErroSistema {

        SessionFactory factory = null; 
        try {
            factory = new Configuration().configure().buildSessionFactory();
            Session session = factory.openSession();
        } catch (JDBCConnectionException erroAbrirSession) {
            throw new ErroSistema(
                    "Não foi possível abrir a conexão com o banco de dados", erroAbrirSession);

        }
        return factory;

    }

    public static Session iniciarTransacao() throws ErroSistema{

        Session session = getInstance().abrirSession().openSession();
        try {
            session.beginTransaction();
        } catch (NullPointerException erroIniciarTransacao) {
            erroIniciarTransacao.getStackTrace();
        } catch (JDBCConnectionException erroIniciarTransacao) {
            erroIniciarTransacao.printStackTrace();
        }
        return session;

    }

    public static void fecharTransacao(Session session) throws ErroSistema{

        try {
            session.getTransaction().commit();
        } catch (NullPointerException erroFecharTransacao) {
            erroFecharTransacao.printStackTrace();
        }
        session.close();

    }

}
