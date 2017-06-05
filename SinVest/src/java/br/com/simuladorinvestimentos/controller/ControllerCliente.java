/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.simuladorinvestimentos.controller;

import br.com.simuladorinvestimentos.model.dao.ClienteDao;
import br.com.simuladorinvestimentos.model.Cliente;
import br.com.simuladorinvestimentos.util.ErroSistema;
import br.com.simuladorinvestimentos.model.Usuario;
import br.com.simuladorinvestimentos.util.Criptografia;
import br.com.simuladorinvestimentos.util.Message;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.exception.JDBCConnectionException;

/**
 *
 * @author Jose Junio
 */
@ManagedBean
@ViewScoped
public class ControllerCliente {

    private Cliente cliente;
    

    public ControllerCliente() {

    }
    
    @PostConstruct
    public void init(){
        cliente  = new Cliente();
    }

    public void salvar(Cliente clienteNovo) throws ErroSistema, IOException {
        try {
            Cliente novo = ClienteDao.getInstance().read(clienteNovo.getCpf());
            Usuario novoLogin = ClienteDao.getInstance().readLogin(clienteNovo.getUsuario().getLogin());
            if (novo == null && novoLogin == null) {
                Usuario usurioNovo = clienteNovo.getUsuario();
                usurioNovo.setSenha(Criptografia.criptografarSenha(clienteNovo.getUsuario().getSenha()));
                clienteNovo.setUsuario(usurioNovo);
                ClienteDao.getInstance().create(clienteNovo);
                Message.getInstance().adicionarMensagem(null, "Cliente Salvo com sucesso", FacesMessage.SEVERITY_INFO);
                ControllerLogin logado = new ControllerLogin();
                logado.validaLogin(clienteNovo.getUsuario().getLogin(), clienteNovo.getUsuario().getSenha());
                FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");

            } else {
                Message.getInstance().adicionarMensagem(null, "Já cadastrado cliente para este CPF ou Login informado", FacesMessage.SEVERITY_WARN);
            }

        } catch (JDBCConnectionException erroAbrirConexao) {
            Message.getInstance().adicionarMensagem(erroAbrirConexao.getMessage(), erroAbrirConexao.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }

        cliente = new Cliente();
    }

    public void excluir() throws ErroSistema {
        try {
            Cliente novo = ClienteDao.getInstance().read(this.cliente.getCpf());
            if (novo == null) {
                Message.getInstance().adicionarMensagem(null, "Cliente não encontrado para este CPF:", FacesMessage.SEVERITY_ERROR);
            } else {
                ClienteDao.getInstance().delete(this.cliente.getCpf());
                Message.getInstance().adicionarMensagem(null, "Cadastro excluído com sucesso", FacesMessage.SEVERITY_INFO);
                cliente = new Cliente();
            }
        } catch (ErroSistema erroExcluir) {
            Message.getInstance().adicionarMensagem(erroExcluir.getMessage(), erroExcluir.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public void alterar() throws ErroSistema {

        try {
            this.setCliente(cliente);
            ClienteDao.getInstance().update(this.cliente);
            Message.getInstance().adicionarMensagem(null, "Cadastro alterado com sucesso", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema erroAlterar) {
            Message.getInstance().adicionarMensagem(erroAlterar.getMessage(), erroAlterar.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        cliente = new Cliente();
    }

    public void consultar(String cpf) throws ErroSistema {
        try {
            this.cliente = ClienteDao.getInstance().read(cpf);
            if (cliente == null) {
                Message.getInstance().adicionarMensagem(null, " Não encontrado Cliente para o CPF informado", FacesMessage.SEVERITY_ERROR);
                this.cliente = new Cliente();
            }

        } catch (ErroSistema erroConsultar) {
            Message.getInstance().adicionarMensagem(erroConsultar.getMessage(), erroConsultar.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public List<Cliente> consultarTodos() throws ErroSistema {

        List<Cliente> clientes = ClienteDao.getInstance().readALL();
        if (clientes == null || clientes.isEmpty()) {
            Message.getInstance().adicionarMensagem(null, "Não existem clientes cadastrados no sistema", FacesMessage.SEVERITY_ERROR);
        }
        return clientes;
    }
    
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
