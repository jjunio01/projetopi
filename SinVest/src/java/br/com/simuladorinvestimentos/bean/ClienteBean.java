/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.simuladorinvestimentos.bean;

import br.com.simuladorinvestimentos.dao.ClienteDao;
import br.com.simuladorinvestimentos.entity.Cliente;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Jose Junio
 */
@RequestScoped
@ManagedBean
public class ClienteBean {

    private Cliente cliente = new Cliente();

    public void salvar(Cliente cli) {
        ClienteDao.getInstance().create(cli);
        cliente = new Cliente();
    }

    public void excluir(String txt) {
        ClienteDao.getInstance().delete(txt);
        cliente = new Cliente();
    }

    public void alterar(Cliente c) {
        ClienteDao.getInstance().update(c);
        cliente = new Cliente();
    }

    public void consultar(String c) {
        this.cliente = ClienteDao.getInstance().read(c);
        cliente = new Cliente();
    }

    public List<Cliente> consultarTodos() {
        return ClienteDao.getInstance().readALL();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
