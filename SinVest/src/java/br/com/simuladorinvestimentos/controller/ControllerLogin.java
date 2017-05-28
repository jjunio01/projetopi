/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.simuladorinvestimentos.controller;

import br.com.simuladorinvestimentos.model.Cliente;
import br.com.simuladorinvestimentos.model.dao.ClienteDao;
import br.com.simuladorinvestimentos.util.Criptografia;
import br.com.simuladorinvestimentos.util.ErroSistema;
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

    private Cliente clienteLogado;

    public ControllerLogin() {
    }

    public String validaLogin(String login, String senha) throws ErroSistema {

        Cliente clienteTeste;

        clienteTeste = ClienteDao.getInstance().readLogado(login);
        login = null;
        if (clienteTeste == null) {

            adicionarMensagem("Erro", "O Login informado não existe.", FacesMessage.SEVERITY_ERROR);
            return null;
        } else {
            if (clienteTeste.getUsuario().getSenha().equals(Criptografia.criptografarSenha(senha))) {

                this.clienteLogado = new Cliente();
                this.clienteLogado.setCpf(clienteTeste.getCpf());
                this.clienteLogado.setDataNasc(clienteTeste.getDataNasc());
                this.clienteLogado.setEmail(clienteTeste.getEmail());
                this.clienteLogado.setId(clienteTeste.getId());
                this.clienteLogado.setNome(clienteTeste.getNome());
                this.clienteLogado.setUsuario(clienteTeste.getUsuario());
                adicionarMensagem("Info", "Usuário Logado", FacesMessage.SEVERITY_INFO);
                return "index.xhtml";

            } else {
                adicionarMensagem("Erro", "Senha incorreta", FacesMessage.SEVERITY_ERROR);

                return null;
            }
        }
    }

    public String logout() {
        this.clienteLogado = null;
        return "Login.xhtml";
    }

    public void adicionarMensagem(String sumario, String detalhe, FacesMessage.Severity tipoErro) {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage mensagem = new FacesMessage(tipoErro, sumario, detalhe);
        context.addMessage(null, mensagem);
    }

    public Cliente getClienteLogado() {
        return clienteLogado;
    }

    public void setClienteLogado(Cliente clienteLogado) {
        this.clienteLogado = clienteLogado;
    }

}
