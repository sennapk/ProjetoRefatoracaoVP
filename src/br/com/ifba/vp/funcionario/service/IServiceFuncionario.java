package br.com.ifba.vp.funcionario.service;

import br.com.ifba.vp.funcionario.model.Funcionario;
import java.util.List;

/**
 *
 * @author Senna
 */
public interface IServiceFuncionario {
    
    /** Busca no banco de dados um Funcionário a partir do seu ID
     * 
     * @param id ID do funcionário que é utilizado na SQL.
     * @return Retorna um objeto Funcionario caso tenha alguma correspondência, do contrário retornará null.
     */
    public abstract Funcionario findById (long id);
    
    /** Busca no banco de dados um Funcionário a partir do seu CPF
     * 
     * @param cpf CPF do funcionário que é utilizado na SQL.
     * @return Retorna um objeto Funcionario caso tenha alguma correspondência, do contrário retornará null.
     */
    public abstract Funcionario findByCPF (String cpf);
    
    /** Busca no banco de dados todos os funcionários salvos.
     * 
     * @return Retorna uma lista com todos os dados de todos os funcionários salvos no banco de dados.
     */
    public abstract List<Funcionario> findAll ();
    
    /** Salva um funcionário no banco de dados.
     * 
     * @param funcionario Objeto que será salvo no banco de dados.
     * @return Retorna o objeto que foi salvo no banco de dados.
     */
    public abstract Funcionario save (Funcionario funcionario);
    
    /** Atualiza os dados de um funcionário no banco de dados.
     * 
     * @param funcionario Objeto contendo o(s) novo(s) dado(s) do funcionário. 
     * @return Retorna o objeto que foi salvo no banco de dados.
     */
    public abstract Funcionario update (Funcionario funcionario);
    
    /** Exclui os dados de um funcionário do banco de dados.
     * 
     * @param funcionario Objeto contendo os dados do funcionário que serão excluídos.
     */
    public abstract void delete (Funcionario funcionario);
    
    /** Faz login no sistema    
     * 
     * @param funcionario Possui os dados de login do usuário
     * @return Retorna um int informando o status do login.
     * Retorna 0 caso o usuário não exista no banco de dados.
     * Retorna 1 caso seja o funcionário gerente
     * Retorna 2 caso o usuário exista no banco de dados.
     */
    public abstract int login (Funcionario funcionario);
}