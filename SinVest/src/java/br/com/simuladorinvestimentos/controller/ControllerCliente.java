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
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.hibernate.exception.JDBCConnectionException;

/**
 *
 * @author Jose Junio
 */
@ManagedBean
@SessionScoped
public class ControllerCliente {

    private Cliente cliente = new Cliente();
    

    public ControllerCliente() {

    }

    public void salvar(Cliente clienteNovo) throws ErroSistema {
        try {
            Cliente novo = ClienteDao.getInstance().read(clienteNovo.getCpf());
            Usuario novoLogin = ClienteDao.getInstance().readLogin(clienteNovo.getUsuario().getLogin());
            if (novo == null && novoLogin == null) {
                Usuario usurioNovo = clienteNovo.getUsuario();
                usurioNovo.setSenha(Criptografia.criptografarSenha(clienteNovo.getUsuario().getSenha()));
                clienteNovo.setUsuario(usurioNovo);
                ClienteDao.getInstance().create(clienteNovo);
                adicionarMensagem(null, "Cliente Salvo com sucesso", FacesMessage.SEVERITY_INFO);
                ControllerLogin logado = new ControllerLogin();
                logado.setClienteLogado(clienteNovo);

            } else {
                adicionarMensagem(null, "Já cadastrado cliente para este CPF informado ou Login", FacesMessage.SEVERITY_WARN);
            }

        } catch (JDBCConnectionException erroAbrirConexao) {
            adicionarMensagem(erroAbrirConexao.getMessage(), erroAbrirConexao.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }

        cliente = new Cliente();
    }

    public void excluir() throws ErroSistema {
        try {
            Cliente novo = ClienteDao.getInstance().read(this.cliente.getCpf());
            if (novo == null) {
                adicionarMensagem(null, "Cliente não encontrado para este CPF:", FacesMessage.SEVERITY_ERROR);
            } else {
                ClienteDao.getInstance().delete(this.cliente.getCpf());
                adicionarMensagem(null, "Cadastro excluído com sucesso", FacesMessage.SEVERITY_INFO);
                cliente = new Cliente();
            }
        } catch (ErroSistema erroExcluir) {
            adicionarMensagem(erroExcluir.getMessage(), erroExcluir.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public void alterar() throws ErroSistema {

        try {
            this.setCliente(cliente);
            ClienteDao.getInstance().update(this.cliente);
            adicionarMensagem(null, "Cadastro alterado com sucesso", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema erroAlterar) {
            adicionarMensagem(erroAlterar.getMessage(), erroAlterar.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        cliente = new Cliente();
    }

    public void consultar(String cpf) throws ErroSistema {
        try {
            this.cliente = ClienteDao.getInstance().read(cpf);
            if (cliente == null) {
                adicionarMensagem(null, " Não encontrado Cliente para o CPF informado", FacesMessage.SEVERITY_ERROR);
            }

        } catch (ErroSistema erroConsultar) {
            adicionarMensagem(erroConsultar.getMessage(), erroConsultar.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public List<Cliente> consultarTodos() throws ErroSistema {

        List<Cliente> clientes = ClienteDao.getInstance().readALL();
        if (clientes == null || clientes.isEmpty()) {
            adicionarMensagem(null, "Não existem clientes cadastrados no sistema", FacesMessage.SEVERITY_ERROR);
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
