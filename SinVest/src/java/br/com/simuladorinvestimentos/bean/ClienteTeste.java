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
        //List<Cliente> clientes = new ArrayList<Cliente>();
        Cliente c2 = new Cliente();
        Cliente c = new Cliente("alteracao TESTEE",cliente.getCliente().getCpf(), null,"email@cliente");
       /*Cliente c2 = new Cliente("ARAUJO SILVA","002", null,"araujo@silva");
        Cliente c3 = new Cliente("TESTE ", "001", null,"teste@001");
        Cliente c4 =  new Cliente("edson", "123", null,"edson@gmail");
        
        cliente.salvar(c2);
        cliente.salvar(c3);
        cliente.salvar(c4);
        */
       
        cliente.consultar("444.444.444-44");
        cliente.getCliente().setNome("cli");
        cliente.getCliente().setCpf("cli");
        cliente.getCliente().setEmail("cli");
        cliente.alterar();
    }
}
