package teste;

import br.com.simuladorinvestimentos.controller.ControllerInvestimentos;
import br.com.simuladorinvestimentos.model.ErroSistema;
import br.com.simuladorinvestimentos.model.InvestCDB;

public class ClienteTeste {

    public static void main(String[] args) throws ErroSistema {
        
        InvestCDB cdb = new InvestCDB();
        ControllerInvestimentos contInvest = new ControllerInvestimentos();
        
        cdb.setPeriodo(30);
        cdb.setValor(8780);
        
       // contInvest.salvarInvestimentos(cdb);
        
        

    }

}
