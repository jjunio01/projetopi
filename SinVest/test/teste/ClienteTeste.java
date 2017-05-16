package teste;

import br.com.simuladorinvestimentos.controller.ControllerCliente;
import br.com.simuladorinvestimentos.controller.ControllerPoupanca;
import br.com.simuladorinvestimentos.controller.ControllerUsuario;
import br.com.simuladorinvestimentos.model.Cliente;
import br.com.simuladorinvestimentos.model.ErroSistema;
import br.com.simuladorinvestimentos.model.Poupanca;
import br.com.simuladorinvestimentos.model.Usuario;
import java.util.Date;

public class ClienteTeste {

    public static void main(String[] args) throws ErroSistema {
        
       
        double txTr = 0.01036;
        double teste;

        ControllerCliente controller = new ControllerCliente();
        Cliente cli = new Cliente();
        Usuario usu = new Usuario();
        ControllerUsuario contUsu = new ControllerUsuario();
        ControllerPoupanca contPoup = new ControllerPoupanca();

        Poupanca poup = new Poupanca();

        poup.setPeriodo(30);
        poup.setValor(1000);
      //  contPoup.salvarPoup(poup);
       // contPoup.calcularRendimentos(poup);


        /* cli.setCpf("09sss5");
        cli.setDataNasc(new Date());
        cli.setEmail("new email");
        cli.setNome("teste login novo");
        usu.setLogin("jTessssaasate");
        usu.setSenha("123");
        cli.setUsu(usu);
        controller.salvar(cli);    
        
        
        
        

        /*usu.setLogin("tLogin");
        usu.setSenha("12345");        
        //Salva o usuário
        contUsu.salvar(usu); 
        //Cria o cliente
        cli.setCpf("111.111.111-22");
        cli.setDataNasc(new Date());
        cli.setEmail("email-teste");
        cli.setNome("junio teste login");
        //Associa o usuario ao cliente        
        cli.setUsu(usu);
        //Salva o cliente
        controller.salvar(cli);*/
    }

}
