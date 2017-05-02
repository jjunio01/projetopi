/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package investimentos.model.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;

/**
 *
 * @author Jose Junio
 */
public class DaoManager<G, T> {
    
    

    public static SessionFactory abrirSession() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        return factory;
    }

    public void cadastrar(G g) {

        Session session = abrirSession().openSession();
        session.beginTransaction();
        session.save(g);
        session.getTransaction().commit();
        session.close();
    }
    
    public G consul(G g){
        Session session = abrirSession().openSession();
        G entity = (G) session.getClass();
        return entity;
    }

    public G consultar(DetachedCriteria criteria) {
       Session session = abrirSession().openSession();
        G entity = (G) criteria.getExecutableCriteria(session).uniqueResult();
        return entity; 
    }

    public void alterar(G g) {

        Session session = abrirSession().openSession();
        session.beginTransaction();
        session.update(g);
        session.getTransaction().commit();
        session.close();

    }

    public void deletar(G g) {

        Session session = abrirSession().openSession();
        session.beginTransaction();
        session.delete(g);
        session.getTransaction().commit();
        session.close();
    }
    
    /*public List<T> retornarLista(G g){
        Session session = abrirSession().openSession();
        
        List<T> entitys = (List<T>) session.createCriteria(class).List(T);
        
        return entitys;
    }*/
   

}
