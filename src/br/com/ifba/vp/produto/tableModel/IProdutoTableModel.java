package br.com.ifba.vp.produto.tableModel;

import br.com.ifba.vp.produto.model.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Senna
 */
public interface IProdutoTableModel {
    public List<Produto> produtos = new ArrayList<>();
    public final String[] colunas = {"Produto", "Preço", "Seção", "Data de Validade", "Estoque"};
}