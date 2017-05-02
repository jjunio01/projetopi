/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package investimentos.view;

import investimentos.model.ClienteModel;
import investimentos.model.entidades.Cliente;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Jose Junio
 */
public class ClienteView {

    public static void main(String[] args) {

        ClienteModel cliModel = new ClienteModel();
        
        Cliente cliente = new Cliente();
        cliente.setNome("Teste");
        cliente.setCpf("novo");
        cliModel.cadastrarCliente(cliente);

    }

}
