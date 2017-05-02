/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package investimentos.model.dao;

import java.util.List;

/**
 *
 * @author Jose Junio
 */
public interface RepositorioGenericoDao<T, G> {

    public void inserir(T t);

    public void alterar(T t);

    public T recuperar(G g);

    public void excluir(T t);

    public List<T> recuperarTodos();

}
