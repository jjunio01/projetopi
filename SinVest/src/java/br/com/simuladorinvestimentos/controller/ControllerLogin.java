/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.simuladorinvestimentos.controller;

import br.com.simuladorinvestimentos.model.Cliente;
import br.com.simuladorinvestimentos.model.dao.ClienteDAO;
import br.com.simuladorinvestimentos.util.Criptografia;
import br.com.simuladorinvestimentos.util.ErroSistema;
import br.com.simuladorinvestimentos.util.Message;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jose Junio
 */
@ManagedBean
@SessionScoped
public class ControllerLogin {

    private Cliente clienteLogado = null;

    public ControllerLogin() {
    }

    public String validaLogin(String login, String senha) throws ErroSistema {

        Cliente clienteTeste;
        //Consulta se existe um cliente cadastrado para o Login informado.
        clienteTeste = ClienteDAO.getInstance().readLogado(login);
        if (clienteTeste == null) {
            Message.getInstance().adicionarMensagem("Erro", "O Login informado não existe.", FacesMessage.SEVERITY_ERROR);
            return null;
        } else {
            if (clienteTeste.getUsuario().getSenha().equals(Criptografia.criptografarSenha(senha))) {
                this.clienteLogado = clienteTeste;
                //Inclui o cliente na sessão.
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", clienteLogado);
                Message.getInstance().adicionarMensagem("Info", "Usuário Logado", FacesMessage.SEVERITY_INFO);
                return "index.xhtml";
            } else {
                Message.getInstance().adicionarMensagem("Erro", "Senha incorreta", FacesMessage.SEVERITY_ERROR);
                return null;
            }
        }
    }

    public String logout() {
        //Retira o cliente da sessão.
        this.clienteLogado = null;
        return "Login.xhtml";
    }

    public Cliente getClienteLogado() {
        return clienteLogado;
    }

    public void setClienteLogado(Cliente clienteLogado) {
        this.clienteLogado = clienteLogado;
    }

}
