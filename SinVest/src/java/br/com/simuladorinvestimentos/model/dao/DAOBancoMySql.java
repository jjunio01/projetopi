/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.simuladorinvestimentos.model.dao;

import br.com.simuladorinvestimentos.util.ErroSistema;
import br.com.simuladorinvestimentos.util.Message;
import javax.faces.application.FacesMessage;
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

    //Obtém uma instancia única do DAOBancoMySql
    public static DAOBancoMySql getInstance() throws ErroSistema {

        if (instance == null) {
            instance = new DAOBancoMySql();
        }
        return instance;
    }

    //Abre sessão para conexão com o banco.
   public SessionFactory abrirSession() throws ErroSistema {

        SessionFactory factory = null;
        try {
            factory = new Configuration().configure().buildSessionFactory();
            Session session = factory.openSession();
        } catch (JDBCConnectionException erroAbrirSession) {
            Message.getInstance().adicionarMensagem(
                    null, "Não foi possível abrir a conexão com o banco de dados", FacesMessage.SEVERITY_INFO);
            throw new ErroSistema(
                    "Não foi possível abrir a conexão com o banco de dados", erroAbrirSession);
        }
        return factory;
}

   //Inicia uma transação com o banco
    public static Session iniciarTransacao() throws ErroSistema {
        //Abre uma sessão de conexão com o banco
        Session session = getInstance().abrirSession().openSession();
        try {
            //Inicia uma transação
            session.beginTransaction();
        } catch (NullPointerException erroIniciarTransacao) {
            erroIniciarTransacao.getStackTrace();
        } catch (JDBCConnectionException erroIniciarTransacao) {
            erroIniciarTransacao.printStackTrace();
        }
        //Retorna uma sessão aberta e com uma transação iniciada
        return session;

    }

    //Recupera a sessão e encerra a transação iniciadas e fecha a conexão.
    public static void fecharTransacao(Session session) throws ErroSistema {

        try {
            //Encerra a transação da sessão recuperada e efetua commit
            session.getTransaction().commit();
        } catch (NullPointerException erroFecharTransacao) {
            erroFecharTransacao.printStackTrace();
        }
        //Fecha a conexão com o banco.
        session.close();

    }

}
