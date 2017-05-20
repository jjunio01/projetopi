package teste;

import br.com.simuladorinvestimentos.controller.ControllerCliente;
import br.com.simuladorinvestimentos.controller.ControllerInvestimentos;
import br.com.simuladorinvestimentos.model.Cliente;
import br.com.simuladorinvestimentos.model.ErroSistema;
import br.com.simuladorinvestimentos.model.InvestCDB;
import br.com.simuladorinvestimentos.model.dao.ClienteDao;

public class ClienteTeste {

    public static void main(String[] args) throws ErroSistema {
        
        InvestCDB cdb = new InvestCDB();
        ControllerInvestimentos contInvest = new ControllerInvestimentos();
        ControllerCliente cliente = new ControllerCliente();
        Cliente cli = new Cliente();
        
        /*cli = ClienteDao.getInstance().read("222.222.222-22");
        
        if (cli == null){
            System.out.println("Não econtrado");
        } else{
            System.out.println("Encontrado");
        }*/
        
        cli = ClienteDao.getInstance().readLogin("logindois");
        
        if(cli == null){
            System.out.println("Nao encontrado");
        } else {
            System.out.println("Encontrado");
        }
        
        
        
        
           
      
        //cdb.setValor(8780);
        
       // contInvest.salvarInvestimentos(cdb);
       
       
       
       
       // System.out.println(Math.pow(2, 3));
        
        

    }

}
