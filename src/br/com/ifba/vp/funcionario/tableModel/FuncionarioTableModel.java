package br.com.ifba.vp.funcionario.tableModel;

import br.com.ifba.vp.funcionario.model.Funcionario;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Senna
 */
public class FuncionarioTableModel extends AbstractTableModel implements IFuncionarioTableModel {

    @Override
    public String getColumnName(int coluna) {
        return FuncionarioTableModel.colunas[coluna];
    }
    
    @Override
    public int getRowCount() {
        return FuncionarioTableModel.funcionarios.size();
    }
    
    @Override
    public int getColumnCount() {
        return FuncionarioTableModel.colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        
        switch (coluna) {
            case 0:
                return FuncionarioTableModel.funcionarios.get(linha).getNome();
            case 1:
                return FuncionarioTableModel.funcionarios.get(linha).getRG();
        }
        
        return null;
    }
    
    public void addElement (Funcionario funcionario) {
        FuncionarioTableModel.funcionarios.add(funcionario);
        fireTableDataChanged();
    }
    
    public void removeElement (int posicao) {
        FuncionarioTableModel.funcionarios.remove(posicao);
        fireTableDataChanged();
    }
}