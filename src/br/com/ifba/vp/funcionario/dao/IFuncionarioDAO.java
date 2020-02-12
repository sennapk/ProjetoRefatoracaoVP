package br.com.ifba.vp.funcionario.dao;

import br.com.ifba.vp.funcionario.model.Funcionario;
import br.com.ifba.vp.infrastructure.dao.IBaseDAO;

/**
 *
 * @author Senna
 */
public interface IFuncionarioDAO extends IBaseDAO<Funcionario>{
    
    /** Faz login no sistema    
     * 
     * @param funcionario Possui os dados de login do usuário
     * @return Retorna um int informando o status do login.
     * Retorna 0 caso o usuário não exista no banco de dados.
     * Retorna 2 caso o usuário exista no banco de dados.
     */
    public abstract int login (Funcionario funcionario);
    
    /** Busca no banco de dados um funcionario a partir do seu CPF
     * 
     * @param cpf CPF do funcionário que é utilizado na SQL.
     * @return Retorna um objeto Funcionario caso tenha alguma correspondência, do contrário retornará null.
     */
    public abstract Funcionario findByCPF (String cpf);
}