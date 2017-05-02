/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package investimentos.model.dao;

import investimentos.model.entidades.Cliente;
import java.util.List;

/**
 *
 * @author Jose Junio
 */
public class ClienteDao implements RepositorioGenericoDao<Cliente, String> {

    DaoManager daoCliente = new DaoManager();

    @Override
    public void inserir(Cliente t) {
        this.daoCliente.cadastrar(t);
    }

    @Override
    public void alterar(Cliente t) {
        this.daoCliente.alterar(t);
    }

    @Override
    public Cliente recuperar(String nome) {
         return (Cliente) (this.daoCliente.consul(nome));    
    }

    @Override
    public void excluir(Cliente t) {
        this.daoCliente.deletar(t);
    }

    @Override
    public List<Cliente> recuperarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
