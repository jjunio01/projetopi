package teste;

import br.com.simuladorinvestimentos.controller.ControllerCliente;
import br.com.simuladorinvestimentos.controller.ControllerInvestimentos;
import br.com.simuladorinvestimentos.model.Cliente;
import br.com.simuladorinvestimentos.util.ErroSistema;
import br.com.simuladorinvestimentos.model.InvestCDB;
import br.com.simuladorinvestimentos.model.Usuario;
import br.com.simuladorinvestimentos.model.dao.ClienteDao;
import br.com.simuladorinvestimentos.util.Criptografia;

public class ClienteTeste {

    public static void main(String[] args) throws ErroSistema {

        InvestCDB cdb = new InvestCDB();
        ControllerInvestimentos contInvest = new ControllerInvestimentos();
        ControllerCliente cliente = new ControllerCliente();
        Cliente cli = new Cliente();
        Usuario usu = new Usuario();
        
        
        String senha = Criptografia.criptografarSenha("123456");
        
        System.out.println(Criptografia.criptografarSenha(senha));
        
        
        if(senha.equals(Criptografia.criptografarSenha("123456"))){
            System.out.println("Senha iguais.");
        } else {
            System.out.println("Senhas diferentes");
        }

        /*cli = ClienteDao.getInstance().read("222.222.222-22");
        
        if (cli == null){
            System.out.println("Não econtrado");
        } else{
            System.out.println("Encontrado");
        }*/
 /* usu = ClienteDao.getInstance().readLogin("login5");
        cli = ClienteDao.getInstance().read("095.737.84-07");
        
        if(cli == null){
            System.out.println("CPF não encontrado");
        } else {
            System.out.println("CPF encontrado");
        }
        
        
         if(usu == null){
            System.out.println("Login não encontrado");
        } else {
            System.out.println("Login encontrado");*/
    }

}
