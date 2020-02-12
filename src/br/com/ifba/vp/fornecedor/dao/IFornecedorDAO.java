package br.com.ifba.vp.fornecedor.dao;

import br.com.ifba.vp.fornecedor.model.Fornecedor;
import br.com.ifba.vp.infrastructure.dao.IBaseDAO;

/**
 *
 * @author Senna
 */
public interface IFornecedorDAO extends IBaseDAO<Fornecedor>{
    
    /** Busca no banco de dados um fornecedor a partir do seu CNPJ
     * 
     * @param cnpj CNPJ do fornecedor que é utilizado na SQL.
     * @return Retorna um objeto Fornecedor caso tenha alguma correspondência, do contrário retornará null.
     */
    public abstract Fornecedor findByCNPJ (String cnpj);
}