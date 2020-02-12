package br.com.ifba.vp.produto.service;

import br.com.ifba.vp.produto.model.Produto;
import java.util.List;

/**
 *
 * @author Senna
 */
public interface IServiceProduto {
    
    /** Busca no banco de dados um Produto a partir do seu ID
     * 
     * @param id ID do produto que é utilizado na SQL.
     * @return Retorna um objeto produto caso tenha alguma correspondência, do contrário retornará null.
     */
    public abstract Produto findById (long id);
    
    /** Busca no banco de dados um Produto a partir do seu código de barras
     * 
     * @param codigo Código de barras do produto que é utilizado na SQL.
     * @return Retorna um objeto produto caso tenha alguma correspondência, do contrário retornará null.
     */
    public abstract Produto findByCodigoBarras (String codigo);
    
    /** Busca no banco de dados um Produto a partir do seu nome
     * 
     * @param name Nome do produto que é utilizado na SQL.
     * @return Retorna um objeto produto caso tenha alguma correspondência, do contrário retornará null.
     */
    public abstract List<Produto> findByName (String name);
    
    /** Busca no banco de dados todos os produtos salvos.
     * 
     * @return Retorna uma lista com todos os dados de todos os produtos salvos no banco de dados.
     */
    public abstract List<Produto> findAll ();
    
    /** Salva um produto no banco de dados.
     * 
     * @param produto Objeto que será salvo no banco de dados.
     * @return Retorna o objeto que foi salvo no banco de dados.
     */
    public abstract Produto save (Produto produto);
    
    /** Atualiza os dados de um produto no banco de dados.
     * 
     * @param produto Objeto que será salvo no banco de dados.
     * @return Retorna o objeto que foi salvo no banco de dados.
     */
    public abstract Produto update (Produto produto);
    
    /** Exclui os dados de produto do banco de dados.
     * 
     * @param produto Objeto contendo os dados do produto que serão excluídos.
     */
    public abstract void delete (Produto produto);
}