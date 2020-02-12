package br.com.ifba.vp.produto.dao;

import br.com.ifba.vp.infrastructure.dao.BaseDAO;
import br.com.ifba.vp.produto.model.Produto;
import java.util.List;
import javax.persistence.NoResultException;

/**
 *
 * @author Senna
 */
public class ProdutoDAO extends BaseDAO<Produto> implements IProdutoDAO {
   
    @Override
    public Produto findByCodigoBarras(String codigo) {
        String sql = "FROM Produto WHERE codigoBarras = '" + codigo + "'";
        
        try {
            return (Produto) entityManager.createQuery(sql).getSingleResult();
        } catch (NoResultException ex) {}
        
        return null;
    }
    
    @Override
    public List<Produto> findByName(String name) {
        String sql = "FROM Produto WHERE nome LIKE '%" + name + "%'";
        
        try {
            return entityManager.createQuery(sql).getResultList();
        } catch (NoResultException ex) {}
        
        return null;
    }
}