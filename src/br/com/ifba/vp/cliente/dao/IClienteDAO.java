package br.com.ifba.vp.cliente.dao;

import br.com.ifba.vp.cliente.model.Cliente;
import br.com.ifba.vp.infrastructure.dao.IBaseDAO;

/**
 *
 * @author Senna
 */
public interface IClienteDAO extends IBaseDAO<Cliente>{
    
    /** Busca no banco de dados um cliente a partir do seu CPF
     * 
     * @param cpf CPF do cliente que é utilizado na SQL.
     * @return Retorna um objeto Cliente caso tenha alguma correspondência, do contrário retornará null.
     */
    public abstract Cliente findByCPF (String cpf);
}