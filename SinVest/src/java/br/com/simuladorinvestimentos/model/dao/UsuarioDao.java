/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.simuladorinvestimentos.model.dao;

import br.com.simuladorinvestimentos.util.ErroSistema;
import br.com.simuladorinvestimentos.model.Usuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Jose Junio
 */
public class UsuarioDao implements DAOGenerico<Usuario> {

    @Override
    public void create(Usuario t) throws ErroSistema{
        Session session = DAOBancoMySql.iniciarTransacao();
        session.save(t);
        DAOBancoMySql.fecharTransacao(session);
    }

    @Override
    public void update(Usuario t)throws ErroSistema{
        Session session = DAOBancoMySql.iniciarTransacao();
        session.update(t);
        DAOBancoMySql.fecharTransacao(session);
    }

    @Override
    public Usuario read(String c) throws ErroSistema{
        Session session = DAOBancoMySql.iniciarTransacao();
        List<Usuario> usuarios = readALL();
        Usuario usu = null;

        for (int i = 0; i < usuarios.size(); i++) {

            if (c.equals(usuarios.get(i).getLogin())) {
                usu = usuarios.get(i);
            }
        }
        DAOBancoMySql.fecharTransacao(session);
        return usu;

    }

    @Override
    public void delete(String c) throws ErroSistema{
        Session session = DAOBancoMySql.iniciarTransacao();
        List<Usuario> usuarios = readALL();
        Usuario usu = null;

        for (int i = 0; i < usuarios.size(); i++) {

            if (c.equals(usuarios.get(i).getLogin())) {
                usu = usuarios.get(i);
            }
        }
        session.delete(usu);
        DAOBancoMySql.fecharTransacao(session);
    }

    @Override
    public List<Usuario> readALL() throws ErroSistema{
        Session session = DAOBancoMySql.iniciarTransacao();
        Query consulta = session.createQuery("from Usuario");
        List<Usuario> clientes = consulta.list();
        DAOBancoMySql.fecharTransacao(session);
        return clientes;
    }

}
