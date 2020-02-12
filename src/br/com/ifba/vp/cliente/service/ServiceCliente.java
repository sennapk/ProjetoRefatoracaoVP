package br.com.ifba.vp.cliente.service;

import br.com.ifba.vp.cliente.dao.ClienteDAO;
import br.com.ifba.vp.cliente.dao.IClienteDAO;
import br.com.ifba.vp.cliente.model.Cliente;
import br.com.ifba.vp.infrastructure.exception.BusinessException;
import br.com.ifba.vp.infrastructure.suport.StringUtil;
import java.util.List;

/**
 *
 * @author Senna
 */
public class ServiceCliente implements IServiceCliente {
    public final static String CLIENTE_NULL = "O cliente é nulo!";
    public final static String CLIENTE_EXISTE = "O cliente já existe!";
    public final static String CLIENTE_NAO_EXISTE = "O cliente não existe!";
    public final static String CLIENTE_INVALIDO = "Cliente inválido!";
    
    private final IClienteDAO clienteDAO = new ClienteDAO();
    
    @Override
    public Cliente findById(long id) {
        return clienteDAO.findById(id);
    }
    
    @Override
    public List<Cliente> findAll() {
        return clienteDAO.findAll();
    }
    
    @Override
    public Cliente findByCPF(String cpf) {
        return clienteDAO.findByCPF(cpf);
    }
    
    @Override
    public Cliente save(Cliente cliente) {
        
        if (cliente == null) {
            return null;
        }
        
        else if (findByCPF(cliente.getCPF()) != null) {
            return null;
        }
        
        else if (!validarCliente(cliente)) {
            return null;
        }
        
        else {
            return clienteDAO.save(cliente);
        }
    }

    @Override
    public Cliente update(Cliente cliente) {
        
        if (cliente == null) {
            return null;
        }
        
        else if (findById(cliente.getId()) == null) {
            return null;
        }
        
        else if (!validarCliente(cliente)){
            return null;
        }
        
        else {
            return clienteDAO.update(cliente);
        }
    }

    @Override
    public void delete(Cliente cliente) {
        
        if (cliente == null) {
            throw new BusinessException (CLIENTE_NULL);
        }
        
        else if (clienteDAO.findById(cliente.getId()) == null) {
            throw new BusinessException (CLIENTE_NAO_EXISTE);
        }
        
        else {
            clienteDAO.delete(cliente);
        }
    }
    
    private boolean validarCliente (Cliente cliente) {
        StringUtil util = new StringUtil();
        
        if (cliente == null) {
            return false;
        }
        
        if (util.isNullOrEmpty(cliente.getNome())){
            return false;
        }
        
        if (util.isNullOrEmpty(cliente.getSexo())) {
            return false;
        }
        
        if (util.isNullOrEmpty(cliente.getCPF())) {
            return false;
        }
        
        return true;
    }
}