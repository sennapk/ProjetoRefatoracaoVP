package br.com.ifba.vp.cliente.service;

import br.com.ifba.vp.cliente.model.Cliente;
import java.util.List;

/**
 *
 * @author Senna
 */
public interface IServiceCliente {
    
    /** Busca no banco de dados um cliente a parte do seu ID
     * 
     * @param id ID do cliente que é utilizado na SQL.
     * @return Retorna um objeto Cliente caso tenha alguma correspondência, do contrário retornará null.
     */
    public abstract Cliente findById (long id);
    
    /** Busca no banco de dados um cliente a parte do seu CPF
     * 
     * @param cpf CPF do cliente que é utilizado na SQL.
     * @return Retorna um objeto Cliente caso tenha alguma correspondência, do contrário retornará null.
     */
    public abstract Cliente findByCPF (String cpf);
    
    /** Busca no banco de dados todos os cliente salvos.
     * 
     * @return Retorna uma lista com todos os dados de todos os clientes salvos no banco de dados.
     */
    public abstract List<Cliente> findAll ();
    
    /** Salva um cliente no banco de dados.
     * 
     * @param cliente Objeto que será salvo no banco de dados.
     * @return Retorna o objeto que foi salvo no banco de dados.
     */
    public abstract Cliente save (Cliente cliente);
    
    /** Atualiza os dados de um cliente salvo no banco de dados.
     * 
     * @param cliente Objeto contendo o(s) novo(s) dado(s) do cliente.
     * @return Retorna o objeto que foi salvo no banco de dados.
     */
    public abstract Cliente update (Cliente cliente);
    
    /** Exclui os dados de um cliente do banco de dados.
     * 
     * @param cliente Objeto contendo os dados do cliente que serão excluídos.
     */
    public abstract void delete (Cliente cliente);
}