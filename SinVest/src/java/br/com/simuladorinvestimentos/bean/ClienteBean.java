/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.simuladorinvestimentos.bean;

import br.com.simuladorinvestimentos.dao.ClienteDao;
import br.com.simuladorinvestimentos.entity.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Jose Junio
 */
@SessionScoped
@ManagedBean
public class ClienteBean {

    private ClienteDao cliDao = new ClienteDao();
    private Cliente cliente = new Cliente();

    public void salvar(Cliente c) {
        this.cliDao.create(cliente);
    }

    public void excluir(String txt) {
        this.cliDao.delete(txt);
    }

    public void alterar(Cliente c) {
        this.cliDao.update(c);
    }

    public Cliente consultar(String c) {
        return this.cliDao.read(c);
    }

    public List<Cliente> consultarTodos() {
        return this.cliDao.readALL();
    }

    public ClienteDao getCliDao() {
        return cliDao;
    }

    public void setCliDao(ClienteDao cliDao) {
        this.cliDao = cliDao;
    }
}
