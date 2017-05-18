/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.simuladorinvestimentos.controller;

import br.com.simuladorinvestimentos.model.dao.ClienteDao;
import br.com.simuladorinvestimentos.model.Cliente;
import br.com.simuladorinvestimentos.model.ErroSistema;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.hibernate.exception.JDBCConnectionException;

/**
 *
 * @author Jose Junio
 */
@ManagedBean
@RequestScoped
public class ControllerCliente {

    private Cliente cliente = new Cliente();

    public ControllerCliente() {

    }

    public void salvar(Cliente cli) throws ErroSistema {
        try {
            //ControllerUsuario contUsu = new ControllerUsuario();
            
           // contUsu.salvar(cli.getUsu());
            ClienteDao.getInstance().create(cli);
            
            adicionarMensagem("Cliente: ", "Salvo com sucesso", FacesMessage.SEVERITY_INFO);
        } catch (JDBCConnectionException erroAbrirConexao) {
            adicionarMensagem(erroAbrirConexao.getMessage(), erroAbrirConexao.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }

        cliente = new Cliente();
    }

    public void excluir() throws ErroSistema {
        try {
            ClienteDao.getInstance().delete(this.cliente.getCpf());
            adicionarMensagem("Cliente: ", "Excluído com sucesso", FacesMessage.SEVERITY_INFO);
            cliente = new Cliente();
        } catch (ErroSistema erroExcluir) {
            adicionarMensagem(erroExcluir.getMessage(), erroExcluir.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public void alterar() throws ErroSistema {

        try {
            this.setCliente(cliente);
            ClienteDao.getInstance().update(this.cliente);
            adicionarMensagem("Cliente: ", "Alterado com sucesso", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema erroAlterar) {
            adicionarMensagem(erroAlterar.getMessage(), erroAlterar.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        cliente = new Cliente();
    }

    public void consultar(String cpf) throws ErroSistema {
        try {
            this.cliente = ClienteDao.getInstance().read(cpf);
            if (cliente == null) {
                adicionarMensagem("Não foi encontrado nenhum cliente:", " para o CPF informado", FacesMessage.SEVERITY_WARN);
            }

        } catch (ErroSistema erroConsultar) {
            adicionarMensagem(erroConsultar.getMessage(), erroConsultar.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public List<Cliente> consultarTodos() throws ErroSistema {

        List<Cliente> clientes = ClienteDao.getInstance().readALL();
        if (clientes == null || clientes.isEmpty()) {
            adicionarMensagem("Não existe nenhum cliente:", " cadastrado no sistema", FacesMessage.SEVERITY_WARN);
        }
        return clientes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void adicionarMensagem(String sumario, String detalhe, FacesMessage.Severity tipoErro) {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage mensagem = new FacesMessage(tipoErro, sumario, detalhe);
        context.addMessage(null, mensagem);
    }

}
