package br.com.ifba.vp.fornecedor.dao;

import br.com.ifba.vp.fornecedor.model.Fornecedor;
import br.com.ifba.vp.infrastructure.dao.BaseDAO;
import javax.persistence.NoResultException;

/**
 *
 * @author Senna
 */
public class FornecedorDAO extends BaseDAO<Fornecedor> implements IFornecedorDAO {
    
    @Override
    public Fornecedor findByCNPJ(String cnpj) {
        String sql = "FROM Fornecedor WHERE cnpj = '" + cnpj + "'";
        
        try {
            return (Fornecedor) entityManager.createQuery(sql).getSingleResult();
        } catch (NoResultException ex) {}
        
        return null;
    }
}