package br.com.ifba.vp.fornecedor.service;

import br.com.ifba.vp.fornecedor.model.Fornecedor;
import java.util.List;

/**
 *
 * @author Senna
 */
public interface IServiceFornecedor {
    
    /** Busca no banco de dados um fornecedor a partir do seu ID
     * 
     * @param id ID do fornecedor que é utilizado na SQL.
     * @return Retorna um objeto Fornecedor caso tenha alguma correspondência, do contrário retornará null.
     */
    public abstract Fornecedor findById (long id);
    
    /** Busca no banco de dados um fornecedor a partir do seu CNPJ
     * 
     * @param cnpj CNPJ do fornecedor que é utilizado na SQL.
     * @return Retorna um objeto Fornecedor caso tenha alguma correspondência, do contrário retornará null.
     */
    public abstract Fornecedor findByCNPJ (String cnpj);
    
    /** Busca no banco de dados todos os fornecedores salvos.
     * 
     * @return Retorna uma lista com todos os dados de todos os fornecedores salvos no banco de dados.
     */
    public abstract List<Fornecedor> findAll ();
    
    /** Salva um fornecedor no banco de dados.
     * 
     * @param fornecedor Objeto que será salvo no banco de dados.
     * @return Retorna o objeto que foi salvo no banco de dados.
     */
    public abstract Fornecedor save (Fornecedor fornecedor);
    
    /** Atualiza os dados de um fornecedor no banco de dados.
     * 
     * @param fornecedor Objeto contendo o(s) novo(s) dado(s) do fornecedor. 
     * @return Retorna o objeto que foi salvo no banco de dados.
     */
    public abstract Fornecedor update (Fornecedor fornecedor);
    
    /** Exclui os dados de um fornecedor do banco de dados.
     * 
     * @param fornecedor Objeto contendo os dados do fornecedor que serão excluídos.
     */
    public abstract void delete (Fornecedor fornecedor);
}