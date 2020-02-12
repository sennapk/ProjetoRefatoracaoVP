package br.com.ifba.vp.fornecedor.service;

import br.com.ifba.vp.fornecedor.dao.FornecedorDAO;
import br.com.ifba.vp.fornecedor.dao.IFornecedorDAO;
import br.com.ifba.vp.fornecedor.model.Fornecedor;
import br.com.ifba.vp.infrastructure.exception.BusinessException;
import br.com.ifba.vp.infrastructure.suport.StringUtil;
import java.util.List;

/**
 *
 * @author Senna
 */
public class ServiceFornecedor implements IServiceFornecedor {
    public final static String FORNECEDOR_NULL = "O fornecedor é nulo!";
    public final static String FORNECEDOR_EXISTE = "O fornecedor já existe!";
    public final static String FORNECEDOR_NAO_EXISTE = "O fornecedor não existe!";
    public final static String FORNECEDOR_INVALIDO = "Fornecedor inválido!";
    
    private final IFornecedorDAO fornecedorDAO = new FornecedorDAO();
    
    @Override
    public Fornecedor findById(long id) {
        return fornecedorDAO.findById(id);
    }

    @Override
    public Fornecedor findByCNPJ(String cnpj) {
        return fornecedorDAO.findByCNPJ(cnpj);
    }
    
    @Override
    public List<Fornecedor> findAll() {
        return fornecedorDAO.findAll();
    }

    @Override
    public Fornecedor save(Fornecedor fornecedor) {
        
        if (fornecedor == null) {
            return null;
        }
        
        else if (findByCNPJ(fornecedor.getCNPJ()) != null) {
            return null;
        }
        
        else if (!validarFornecedor(fornecedor)) {
            return null;
        }
        
        else {
            return fornecedorDAO.save(fornecedor);
        }
    }
    
    @Override
    public Fornecedor update(Fornecedor fornecedor) {
        
        if (fornecedor == null) {
            return null;
        }
        
        else if (findById(fornecedor.getId()) == null) {
            return null;
        }
        
        else if (!validarFornecedor(fornecedor)) {
            return null;
        }
        
        else {
            return fornecedorDAO.update(fornecedor);
        }
    }
    
    @Override
    public void delete(Fornecedor fornecedor) {
        
        if (fornecedor == null) {
            throw new BusinessException (FORNECEDOR_NULL);
        }
        
        else if (fornecedorDAO.findById(fornecedor.getId()) == null) {
            throw new BusinessException (FORNECEDOR_NAO_EXISTE);
        }
        
        else {
            fornecedorDAO.delete(fornecedor);
        }
    }
    
    private boolean validarFornecedor (Fornecedor fornecedor) {
        StringUtil util = new StringUtil();
        
        if (fornecedor == null) {
            return false;
        }
        
        if (util.isNullOrEmpty(fornecedor.getRazaoSocial())) {
            return false;
        }
        
        if (util.isNullOrEmpty(fornecedor.getCNPJ())) {
            return false;
        }
        
        return true;
    }
}