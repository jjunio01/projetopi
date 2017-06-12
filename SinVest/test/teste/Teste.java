package teste;

import br.com.simuladorinvestimentos.controller.ControllerCliente;
import br.com.simuladorinvestimentos.model.Cliente;
import br.com.simuladorinvestimentos.model.HistoricoInvestimentos;
import br.com.simuladorinvestimentos.model.Usuario;
import br.com.simuladorinvestimentos.util.ErroSistema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Teste {

    // ai é só jogar o atributo na sessão e recuperá-lo quando quiser. //métodos auxiliares que podem te ajudar: public FacesContext getFacesContext() { return FacesContext.getCurrentInstance(); } public HttpSession getSession() { return (HttpSession) getFacesContext().getExternalContext().getSession(false); } public HttpServletRequest getRequestSession() { return (HttpServletRequest) getFacesContext().getExternalContext().getRequest(); } 
    public static void main(String[] args) throws ErroSistema, IOException {

        ControllerCliente contCliente = new ControllerCliente();
        
        Cliente cliente = new Cliente();
        contCliente.consultar("222.222.222-22");
        cliente = contCliente.getCliente();
        cliente.setNome("Novo");
        contCliente.setCliente(cliente); 
        HistoricoInvestimentos his = new HistoricoInvestimentos();
        his.setDataAcesso(new Date());
        List<HistoricoInvestimentos> test = new ArrayList<>();
        test.add(his);
        
        cliente.setHistorico(test);
        contCliente.alterar();
        
        
        /*HistoricoInvestimentos his = new HistoricoInvestimentos();
        his.setDataAcesso(new Date());
        List<HistoricoInvestimentos> test = new ArrayList<>();
        test.add(his);
        cliente.setHistorico(test);
        cliente.setCpf("123");
        cliente.setNome("sss");
        cliente.setDataNasc(new Date());
        Usuario us = new Usuario();
        us.setLogin("silva");
        us.setSenha("123");
        cliente.setUsuario(us);
        contCliente.salvar(cliente);*/

    }

}
