package br.com.ifba.vp.cliente.dao;

import br.com.ifba.vp.cliente.model.Cliente;
import br.com.ifba.vp.infrastructure.dao.BaseDAO;
import javax.persistence.NoResultException;

/**
 *
 * @author Senna
 */
public class ClienteDAO extends BaseDAO<Cliente> implements IClienteDAO {
    
    @Override
    public Cliente findByCPF(String cpf) {
        String sql = "FROM Cliente WHERE cpf = '" + cpf + "'";
        
        try {
            return (Cliente) entityManager.createQuery(sql).getSingleResult();
        } catch (NoResultException ex) {}
        
        return null;
    }
}