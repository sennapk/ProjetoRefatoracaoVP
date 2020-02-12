package br.com.ifba.vp.produto.service;

import br.com.ifba.vp.infrastructure.exception.BusinessException;
import br.com.ifba.vp.infrastructure.suport.StringUtil;
import br.com.ifba.vp.produto.dao.IProdutoDAO;
import br.com.ifba.vp.produto.dao.ProdutoDAO;
import br.com.ifba.vp.produto.model.Produto;
import java.util.List;

/**
 *
 * @author Senna
 */
public class ServiceProduto implements IServiceProduto {
    public final static String PRODUTO_NULL = "O produto é nulo!";
    public final static String PRODUTO_EXISTE = "O produto já existe!";
    public final static String PRODUTO_NAO_EXISTE = "O produto não existe!";
    public final static String PRODUTO_INVALIDO = "Produto inválido!";
    
    private final IProdutoDAO produtoDAO = new ProdutoDAO();

    @Override
    public Produto findById(long id) {
        return produtoDAO.findById(id);
    }

    @Override
    public Produto findByCodigoBarras(String codigo) {
        return produtoDAO.findByCodigoBarras(codigo);
    }
    
    @Override
    public List<Produto> findByName(String name) {
        return produtoDAO.findByName(name);
    }
    
    @Override
    public List<Produto> findAll() {
        return produtoDAO.findAll();
    }
    
    @Override
    public Produto save(Produto produto) {
        
        if (produto == null) {
            return null;
        }
        
        else if (findByCodigoBarras(produto.getCodigoBarras()) != null) {
            return null;
        }
        
        else if (!validarProduto(produto)) {
            return null;
        }
        
        else {
            return produtoDAO.save(produto);
        }
    }

    @Override
    public Produto update(Produto produto) {
        
        if (produto == null) {
            return null;
        }
        
        else if (findById(produto.getId()) == null) {
            return null;
        }
        
        else if (!validarProduto(produto)) {
            return null;
        }
        
        else {
            return produtoDAO.update(produto);
        }
    }

    @Override
    public void delete(Produto produto) {
        
        if (produto == null) {
            throw new BusinessException (PRODUTO_NULL);
        }
        
        else if (findById(produto.getId()) == null) {
            throw new BusinessException (PRODUTO_NAO_EXISTE);
        }
        
        else {
            produtoDAO.delete(produto);
        }
    }
    
    private boolean validarProduto (Produto produto) {
        StringUtil util = new StringUtil();
        
        if (produto == null) {
            return false;
        }
        
        if (util.isNullOrEmpty(produto.getNome())){
            return false;
        }
        
        if (util.isNullOrEmpty(produto.getCodigoBarras())) {
            return false;
        }
        
        if (produto.getPreco() <= 0) {
            return false;
        }
        
        if (produto.getEstoque() < 0) {
            return false;
        }
        
        return true;
    }
}