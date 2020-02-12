package br.com.ifba.vp.produto.dao;

import br.com.ifba.vp.produto.model.Produto;
import java.util.List;
import br.com.ifba.vp.infrastructure.dao.IBaseDAO;

/**
 *
 * @author Senna
 */
public interface IProdutoDAO extends IBaseDAO<Produto>{
    
    /** Busca no banco de dados um produto a partir do seu código de barras
     * 
     * @param codigo Código de barras do produto que é utilizado na SQL.
     * @return Retorna um objeto Produto caso tenha alguma correspondência, do contrário retornará null.
     */
    public abstract Produto findByCodigoBarras (String codigo);
    
    /** Busca no banco de dados um produto a partir do seu nome
     * 
     * @param name Nome do produto que é utilizado na SQL.
     * @return Retorna um objeto Produto caso tenha alguma correspondência, do contrário retornará null.
     */
    public abstract List<Produto> findByName (String name);
}