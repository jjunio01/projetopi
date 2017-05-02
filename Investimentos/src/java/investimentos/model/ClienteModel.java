package investimentos.model;

import investimentos.model.entidades.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ClienteModel {

    public static SessionFactory abrirSession() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        return factory;
    }

    public void cadastrarCliente(Cliente cliente) {

        Session session = abrirSession().openSession();
        session.beginTransaction();
        session.save(cliente);
        session.getTransaction().commit();
        session.close();
    }

    public Cliente consultarCliente(int id) {
        Session session = abrirSession().openSession();
        Cliente cliente = (Cliente) session.get(Cliente.class, id);
        return cliente;
    }

    public void alterarCliente(Cliente cliente) {

        Session session = abrirSession().openSession();
        session.beginTransaction();
        session.update(cliente);
        session.getTransaction().commit();
        session.close();

    }

    public void deletarCliente(Cliente cliente) {

        Session session = abrirSession().openSession();
        session.beginTransaction();
        session.delete(cliente);
        session.getTransaction().commit();
        session.close();
    }

}
