/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.simuladorinvestimentos.bean;

import br.com.simuladorinvestimentos.dao.ClienteDao;
import br.com.simuladorinvestimentos.entity.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jose Junio
 */
public class ClienteTeste {

    public static void main(String[] args) {

        ClienteBean cliente = new ClienteBean();
        Cliente cli = null;
        List<Cliente> clientes = new ArrayList<Cliente>();
        /*Cliente c = new Cliente("JOSE JUNIO","003", null,"jose@junio");
        Cliente c2 = new Cliente("ARAUJO SILVA","002", null,"araujo@silva");
        Cliente c3 = new Cliente("TESTE ", "001", null,"teste@001");
        Cliente c4 =  new Cliente("edson", "123", null,"edson@gmail");

        cliente.salvar(c);
        cliente.salvar(c2);
        cliente.salvar(c3);
        cliente.salvar(c4);*/

        cli = ClienteDao.getInstance().read("987.654.321-99");
        System.out.println("Nome: " + cli.getNome() + "E-mail: " + cli.getEmail());

        /* clientes = ClienteDao.getInstance().readALL();
        
        //for(int i = 0; i < clientes.size(); i++){
       //     System.out.println("Nome" + clientes.get(i).getNome());
       // }
        //  cliente.excluir("00000000000");

        //System.out.println("Nome: " + cli.getNome());

        //System.out.println("dskjfkjdfh"); 
        //System.out.println("Nome: " + cliente.consultar("001").getNome());
    }*/
    }
}
