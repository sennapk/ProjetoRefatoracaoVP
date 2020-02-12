package br.com.ifba.vp.produto.tableModel;

import br.com.ifba.vp.produto.model.Produto;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Senna
 */
public class ProdutoTableModel extends AbstractTableModel implements IProdutoTableModel {
    
    @Override
    public String getColumnName(int coluna) {
        return ProdutoTableModel.colunas[coluna];
    }
    
    @Override
    public int getRowCount() {
        return ProdutoTableModel.produtos.size();
    }
    
    @Override
    public int getColumnCount() {
        return ProdutoTableModel.colunas.length;
    }
    
    @Override
    public Object getValueAt(int linha, int coluna) {
        
        switch (coluna) {
            case 0:
                return ProdutoTableModel.produtos.get(linha).getNome();
            case 1:
                return ProdutoTableModel.produtos.get(linha).getPreco();
            case 2:
                return ProdutoTableModel.produtos.get(linha).getSecao();
            case 3:
                return ProdutoTableModel.produtos.get(linha).getDataValidade();
            case 4:
                return ProdutoTableModel.produtos.get(linha).getEstoque();
        }
    
        return null;
    }
    
    public void addElement (Produto produto) {
        ProdutoTableModel.produtos.add(produto);
        fireTableDataChanged();
    }
    
    public void removeElement (int posicao) {
        ProdutoTableModel.produtos.remove(posicao);
        fireTableDataChanged();
    }
}