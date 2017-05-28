package teste;

import br.com.simuladorinvestimentos.controller.ControllerLogin;
import br.com.simuladorinvestimentos.model.Cliente;
import br.com.simuladorinvestimentos.model.dao.ClienteDao;
import br.com.simuladorinvestimentos.util.ErroSistema;

public class ClienteTeste {

    public static void main(String[] args) throws ErroSistema {

        String login = "test";

        ControllerLogin logado = new ControllerLogin();

        Cliente cliente = ClienteDao.getInstance().readLogado(login);

        if (cliente == null) {
            System.out.println(cliente.getNome());
        }

    }

}
