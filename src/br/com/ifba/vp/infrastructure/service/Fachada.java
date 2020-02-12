package br.com.ifba.vp.infrastructure.service;

import br.com.ifba.vp.cliente.model.Cliente;
import br.com.ifba.vp.cliente.service.IServiceCliente;
import br.com.ifba.vp.cliente.service.ServiceCliente;
import br.com.ifba.vp.fornecedor.model.Fornecedor;
import br.com.ifba.vp.fornecedor.service.IServiceFornecedor;
import br.com.ifba.vp.fornecedor.service.ServiceFornecedor;
import br.com.ifba.vp.funcionario.model.Funcionario;
import br.com.ifba.vp.funcionario.service.IServiceFuncionario;
import br.com.ifba.vp.funcionario.service.ServiceFuncionario;
import br.com.ifba.vp.produto.model.Produto;
import br.com.ifba.vp.produto.service.IServiceProduto;
import br.com.ifba.vp.produto.service.ServiceProduto;
import java.util.List;

/**
 *
 * @author Senna
 */
public class Fachada {
    private volatile static Fachada instance; 
    
    private final IServiceCliente serviceCliente = new ServiceCliente();
    private final IServiceFornecedor serviceFornecedor = new ServiceFornecedor();
    private final IServiceFuncionario serviceFuncionario = new ServiceFuncionario();
    private final IServiceProduto serviceProduto = new ServiceProduto();

    public static Fachada getInstance() {
        if (instance == null) {
            synchronized (Fachada.class) {
                if (instance == null) {
                    instance = new Fachada();
                }
            }
        }
        
        return instance;
    }
    
    // ========================================= CLIENTE ====================================== //

    public Cliente findByIdCliente(long id) {
        return serviceCliente.findById(id);
    }

    public Cliente findByCPFCliente(String cpf) {
        return serviceCliente.findByCPF(cpf);
    
    }
    
    public List<Cliente> findAllCliente() {
        return serviceCliente.findAll();
    }
    
    public Cliente saveCliente(Cliente cliente) {
        return serviceCliente.save(cliente);
    }

    public Cliente updateCliente(Cliente cliente) {
        return serviceCliente.update(cliente);
    }
    
    public void deleteCliente(Cliente cliente) {
        serviceCliente.delete(cliente);
    }
    
    // ========================================= FORNECEDOR ====================================== //
    
    public Fornecedor findByIdFornecedor(long id) {
        return serviceFornecedor.findById(id);
    }

    public Fornecedor findByCNPJFornecedor(String cnpj) {
        return serviceFornecedor.findByCNPJ(cnpj);
    }
    
    public List<Fornecedor> findAllFornecedor() {
        return serviceFornecedor.findAll();
    }
    
    public Fornecedor saveFornecedor(Fornecedor fornecedor) {
        return serviceFornecedor.save(fornecedor);
    }

    public Fornecedor updateFornecedor(Fornecedor fornecedor) {
        return serviceFornecedor.update(fornecedor);
    }
    
    public void deleteFornecedor(Fornecedor fornecedor) {
        serviceFornecedor.delete(fornecedor);
    }
    
    // ========================================= FUNCIONÁRIO ====================================== //
   
    public Funcionario findByIdFuncionario (long id) {
        return serviceFuncionario.findById(id);
    }

    public Funcionario findByCPFFuncionario(String cpf) {
        return serviceFuncionario.findByCPF(cpf);
    }
    
    public List<Funcionario> findAllFuncionario () {
        return serviceFuncionario.findAll();
    }
    
    public Funcionario saveFuncionario (Funcionario funcionario) {
        return serviceFuncionario.save(funcionario);
    }
    
    public Funcionario updateFuncionario (Funcionario funcionario) {
        return serviceFuncionario.update(funcionario);
    }
    
    public void deleteFuncionario (Funcionario funcionario) {
        serviceFuncionario.delete(funcionario);
    }
    
    public int loginFuncionario(Funcionario funcionario) {
        return serviceFuncionario.login(funcionario);
    }
    
    // ========================================= PRODUTO ====================================== //
    
    public Produto findByIdProduto(long id) {
        return serviceProduto.findById(id);
    }

    public Produto findByCodigoBarras(String codigo) {
        return serviceProduto.findByCodigoBarras(codigo);
    }
    
    public List<Produto> findByName(String nome) {
        return serviceProduto.findByName(nome);
    }
    
    public List<Produto> findAllProduto() {
        return serviceProduto.findAll();
    }
    
    public Produto saveProduto (Produto produto){
        return serviceProduto.save(produto);
    }
    
    public Produto updateProduto(Produto produto) {
        return serviceProduto.update(produto);
    }
    
    public void deleteProduto(Produto produto) {
        serviceProduto.delete(produto);
    }
}