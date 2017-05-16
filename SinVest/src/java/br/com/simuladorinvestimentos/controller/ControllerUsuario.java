/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.simuladorinvestimentos.controller;

import br.com.simuladorinvestimentos.model.ErroSistema;
import br.com.simuladorinvestimentos.model.dao.UsuarioDao;
import br.com.simuladorinvestimentos.model.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Jose Junio
 */
@ManagedBean
@SessionScoped
public class ControllerUsuario {

    private Usuario usuario;

    public void salvar(Usuario u) throws ErroSistema {
        UsuarioDao usuDao = new UsuarioDao();
        usuDao.create(u);
    }
    
    public Usuario consultar(String login) throws ErroSistema{
        UsuarioDao usuDao = new UsuarioDao();
        return usuDao.read(login);
        
    }

    public ControllerUsuario() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
