/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.simuladorinvestimentos.bean;

import br.com.simuladorinvestimentos.entity.Cliente;

/**
 *
 * @author Jose Junio
 */
public class ClienteTeste {
    
    public static void main(String[] args){
        
        ClienteBean cliente = new ClienteBean();
        Cliente cli = null;
        /*Cliente c = new Cliente("JOSE JUNIO", "003");
        Cliente c2 = new Cliente("ARAUJO SILVA", "002");
        Cliente c3 = new Cliente("TESTE ", "001");
        
        cliente.salvar(c);
        cliente.salvar(c2);
        cliente.salvar(c3);*/
        
        
        
        
        
        System.out.println("Nome: " + cliente.consultar("001").getNome());
        
        
        
            
    }
    
}
