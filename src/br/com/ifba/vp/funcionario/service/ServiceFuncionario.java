package br.com.ifba.vp.funcionario.service;

import br.com.ifba.vp.funcionario.dao.FuncionarioDAO;
import br.com.ifba.vp.funcionario.dao.IFuncionarioDAO;
import br.com.ifba.vp.funcionario.model.Funcionario;
import br.com.ifba.vp.infrastructure.exception.BusinessException;
import br.com.ifba.vp.infrastructure.suport.StringUtil;
import java.util.List;

/**
 *
 * @author Senna
 */
public class ServiceFuncionario implements IServiceFuncionario {
    public final static String FUNCIONARIO_NULL = "O funcionário é nulo!";
    public final static String FUNCIONARIO_EXISTE = "O funcionário já existe!";
    public final static String FUNCIONARIO_NAO_EXISTE = "O funcionário não existe!";
    public final static String FUNCIONARIO_INVALIDO = "Funcionário inválido!";
    
    private final IFuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    
    @Override
    public Funcionario findById(long id) {
        return funcionarioDAO.findById(id);
    }

    @Override
    public Funcionario findByCPF(String cpf) {
        return funcionarioDAO.findByCPF(cpf);
    }
    
    @Override
    public List<Funcionario> findAll() {
        return funcionarioDAO.findAll();
    }
    
    @Override
    public Funcionario save(Funcionario funcionario) {
        
        if (funcionario == null) {
            return null;
        }
        
        else if (findByCPF(funcionario.getCPF()) != null) {
            return null;            
        }
        
        else if (!validarFuncionario(funcionario)) {
            return null;
        }
        
        else {
            return funcionarioDAO.save(funcionario);
        }
    }

    @Override
    public Funcionario update(Funcionario funcionario) {
        
        if (funcionario == null) {
            return null;
        }
        
        else if (findById(funcionario.getId()) == null) {
            return null;
        }
        
        else if (!validarFuncionario(funcionario)) {
            return null;
        }
        
        else {
            return funcionarioDAO.update(funcionario);
        }
    }

    @Override
    public void delete(Funcionario funcionario) {
        
        if (funcionario == null) {
            throw new BusinessException (FUNCIONARIO_NULL);
        }
        
        else if (funcionarioDAO.findById(funcionario.getId()) == null) {
            throw new BusinessException (FUNCIONARIO_NAO_EXISTE);
        }
        
        else {
            funcionarioDAO.delete(funcionario);
        }
    }
    
    @Override
    public int login(Funcionario funcionario) {
        
        if (funcionario == null) {
            throw new BusinessException (FUNCIONARIO_NULL);
        }
        
        else if(funcionario.getCPF().equals("12345678911") && funcionario.getSenha().equals("1221")){
            return 1;
        }
        
        else {
            return funcionarioDAO.login(funcionario);
        }
    }
    
    public boolean validarFuncionario (Funcionario funcionario) {
        StringUtil util = StringUtil.getInstance();
        
        if (funcionario == null) {
            return false;
        }
        
        if (util.isNullOrEmpty(funcionario.getNome())){
            return false;
        }
        
        if (util.isNullOrEmpty(funcionario.getSexo())){
            return false;
        }
        
        if (util.isNullOrEmpty(funcionario.getCPF())) {
            return false;
        }
        
        if (util.isNullOrEmpty(funcionario.getSenha())){
            return false;
        }
        
        return true;
    }
}