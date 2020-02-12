package br.com.ifba.vp.funcionario.dao;

import br.com.ifba.vp.funcionario.model.Funcionario;
import br.com.ifba.vp.infrastructure.dao.BaseDAO;
import javax.persistence.NoResultException;

/**
 *
 * @author Senna
 */
public class FuncionarioDAO extends BaseDAO<Funcionario> implements IFuncionarioDAO {
    
    @Override
    public int login(Funcionario funcionario) {
        String sql = "FROM Funcionario WHERE cpf = '" + funcionario.getCPF() + "' AND senha = '" + funcionario.getSenha() + "'";
        
        try {
            return  entityManager.createQuery(sql).getSingleResult() != null ? 2 : 0;
        } catch (NoResultException ex) {}
        
        return 0;
    }

    @Override
    public Funcionario findByCPF(String cpf) {
        String sql = "FROM Funcionario WHERE cpf = '" + cpf + "'";
        
        try {
            return (Funcionario) entityManager.createQuery(sql).getSingleResult();
        } catch (NoResultException ex) {}
         
        return null;
    }
}